package com.itbaizhan.myconsumer1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeadQueueConsumer {
    @RabbitListener(queues = "normal_queue")
    public void listener(Message message, Channel channel) throws IOException {


        channel.basicNack(message.getMessageProperties().getDeliveryTag(),true,false);
    }

}
