package com.itbaizhan.mq.publish;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 站内信消费者
 */
public class CustomerStation {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.66.200");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("rabbit");
        connectionFactory.setPassword("rabbit");
        connectionFactory.setVirtualHost("/");
        // 2.创建连接
        Connection connection = connectionFactory.newConnection();
        // 3.创建信道
        Channel channel = connection.createChannel();
        // 4.监听队列
        channel.basicConsume("SEND_STATION",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println("发送站内信："+message);
            }
        });
    }
}
