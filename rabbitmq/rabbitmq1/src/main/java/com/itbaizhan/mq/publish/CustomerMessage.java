package com.itbaizhan.mq.publish;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 短信消费者
 */
public class CustomerMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.66.200");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("rabbit");
        connectionFactory.setPassword("rabbit");
        connectionFactory.setVirtualHost("/");// 默认虚拟机
        //2.创建连接
        Connection conn = connectionFactory.newConnection();
        //3.建立信道
        Channel channel = conn.createChannel();
        // 4.监听队列
        channel.basicConsume("SEND_MESSAGE", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println("发送短信1："+message);
            }
        });
    }
}
