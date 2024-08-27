package com.itbaizhan.myorder.controller;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @GetMapping("/place/{orderId}")
//    public String order(@PathVariable String orderId){
//        System.out.println("处理订单数据...");
//        rabbitTemplate.convertAndSend("order_exchange","order_routing",orderId);
//        return "下单成功，修改库存";
//    }

    @GetMapping("/places/{orderId}")
    public String order2(@PathVariable String orderId){
        System.out.println("处理订单数据...");
        // 设置消息延迟时间为10秒
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay(10000);
                return message;
            }
        };
        rabbitTemplate.convertAndSend("delayed_exchange","order_routing",orderId,messagePostProcessor);
        return "下单成功，修改库存";
    }

}
