package com.itbaizhan.myconsumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UnFailConsumer {

//    @RabbitListener(queues = "my_queue")
    public void consumer1(Message message, Channel channel) throws IOException, InterruptedException {
        //消费消息
        System.out.println("消费者1："+new String(message.getBody()));
        //模拟业务场景
        Thread.sleep(500);
        //手动签收消息
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }


//    @RabbitListener(queues = "my_queue")
    public void consumer2(Message message, Channel channel) throws IOException, InterruptedException {
        //消费消息
        System.out.println("消费者2："+new String(message.getBody()));
        //模拟业务场景
        Thread.sleep(3000);
        //手动签收消息
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

}
