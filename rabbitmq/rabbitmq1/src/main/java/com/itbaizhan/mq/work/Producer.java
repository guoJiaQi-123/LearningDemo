package com.itbaizhan.mq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq工作队列模式<b>生产者</b>
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.66.200");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        //2.创建连接
        Connection connection = connectionFactory.newConnection();
        //3.创建信道
        Channel channel = connection.createChannel();
        //4.创建队列                           持久化     私有化    自动删除
        channel.queueDeclare("work_queue",true,false,false,null);
        //5.发送大量消息
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("","work_queue", MessageProperties.PERSISTENT_TEXT_PLAIN,
                    ("这是发送的第"+i+"条消息").getBytes());
        }
        //6.关闭连接和信道
        channel.close();
        connection.close();
    }
}
