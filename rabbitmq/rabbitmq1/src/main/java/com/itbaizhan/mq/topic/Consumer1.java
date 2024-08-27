package com.itbaizhan.mq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq通配符模式<b>消费者—1</b>
 */
public class Consumer1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory =new ConnectionFactory();
        connectionFactory.setHost("192.168.66.200");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("rabbit");
        connectionFactory.setPassword("rabbit");
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        //消费消息      参数一：要消费哪个队列中的消息（队列名）    参数二：是否自动回复     参数三：怎么消费消息
        /*
         *  参数1：监听的队列名
         *  参数2：是否自动签收，如果设置为false，则需要手动确认消息已收到，否则MQ会一直发送消息
         *  参数3：Consumer的实现类，重写该类方法表示接受到消息后如何消费
         */
        channel.basicConsume("SEND_MAIL3",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"utf-8");
                System.out.println("发邮箱："+message);
            }
        });
    }
}
