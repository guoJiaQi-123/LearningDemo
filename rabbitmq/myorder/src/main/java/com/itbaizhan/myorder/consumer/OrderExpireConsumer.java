package com.itbaizhan.myorder.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderExpireConsumer {


//    @RabbitListener(queues = "expire_queue")
    public void listener(String message){
        System.out.println("查询"+message+"号订单，如果已支付，则无需要更改，如果未支付，则回退库存");
    }

    @RabbitListener(queues = "delayed_queue")
    public void listener_delayed_queue(String message){
        System.out.println("查询"+message+"号订单，如果已支付，则无需要更改，如果未支付，则回退库存");
    }
}
