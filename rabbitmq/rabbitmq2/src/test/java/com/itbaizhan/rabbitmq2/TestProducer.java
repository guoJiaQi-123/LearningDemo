package com.itbaizhan.rabbitmq2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage(){
        /*
         *  参数一：发送给哪个交换机的交换机名称
         *  参数二：路由关键字
         *  参数三：发送的消息
         */
        rabbitTemplate.convertAndSend("boot_exchange_topic","message","springboot发送消息");
    }
}
