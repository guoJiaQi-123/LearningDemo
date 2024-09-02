package com.itbaizhan.mq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 通配符模式-生产者
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.66.200");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("rabbit");
        connectionFactory.setPassword("rabbit");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare("exchange_topic", BuiltinExchangeType.TOPIC, true);
        //创建队列
        channel.queueDeclare("SEND_MAIL3", true, false, false, null);
        channel.queueDeclare("SEND_MESSAGE3", true, false, false, null);
        channel.queueDeclare("SEND_STATION3", true, false, false, null);
        //绑定队列与交换机
        channel.queueBind("SEND_MAIL3", "exchange_topic", "#.mail.#");
        channel.queueBind("SEND_MESSAGE3", "exchange_topic", "#.message.#");
        channel.queueBind("SEND_STATION3", "exchange_topic", "#.station.#");
        //发送消息
        channel.basicPublish("exchange_topic", "mail.station.message", null,
                "双十一大促".getBytes());
        channel.basicPublish("exchange_topic", "station", null, "小促销".getBytes());
        //关闭资源
        channel.close();
        connection.close();
    }
}
