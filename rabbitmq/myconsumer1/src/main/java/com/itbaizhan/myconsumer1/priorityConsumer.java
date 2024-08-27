package com.itbaizhan.myconsumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class priorityConsumer {

//    @RabbitListener(queues = "priority_queue")
    public void priorityConsumer(Message message, Channel channel) throws IOException {
        //1.消费消息
        System.out.println(new String(message.getBody()));
        //2.手动提交
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }

}
