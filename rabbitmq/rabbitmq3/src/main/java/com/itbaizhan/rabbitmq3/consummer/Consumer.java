package com.itbaizhan.rabbitmq3.consummer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    // 监听队列
    @RabbitListener(queues = "boot_queue")
    public void listen_message(String message){
        System.out.println("发送短信"+message);
    }

}
