package com.itbaizhan.myconsumer1;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AckConsumer {

//    @RabbitListener(queues = "my_queue")
    public void consumer(Message message, Channel channel) throws IOException, InterruptedException {
        // 消息投递序号，消息每次投递该值都会+1
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //所有处理消息的代码全部写道try中，在最后手动签收
        try {
            System.out.println("成功接收消息："+new String(message.getBody()));
            /**
             * 手动签收消息
             * 参数一：消息的投递序号
             * 参数二：是否可以一次性签收多条消息
             */
            channel.basicAck(deliveryTag,true);
        }catch (Exception e){
            System.out.println("消息消费失败！");
            Thread.sleep(5000);
            /**
             * 手动拒签消息
             * 参数一：消息的投递序号
             * 参数二：是否可以一次性拒签多条消息
             * 参数三：拒签的消息是否回退到队列中
             */
            channel.basicNack(deliveryTag,true,true);
        }

    }

}
