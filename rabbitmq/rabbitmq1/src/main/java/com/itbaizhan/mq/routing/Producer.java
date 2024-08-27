package com.itbaizhan.mq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * rabbitmq路由模式-生产者
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
        //创建交换机             参数一：交换机名        参数二：交换机类型       参数三：交换机是否持久化
        channel.exchangeDeclare("exchange_routing", BuiltinExchangeType.DIRECT,true);
        //创建队列      参数一：队列名  参数二：持久化   参数三：私有化   参数四：自动删除   参数五：其他配置
        channel.queueDeclare("SEND_MAIL2",true,false,false,null);
        channel.queueDeclare("SEND_MESSAGE2",true,false,false,null);
        channel.queueDeclare("SEND_STATION2",true,false,false,null);
        //绑定队列和交换机  参数一：队列名，参数二：交换机名，参数三：路由关键字
        channel.queueBind("SEND_MAIL2","exchange_routing","import");
        channel.queueBind("SEND_MESSAGE2","exchange_routing","import");
        channel.queueBind("SEND_STATION2","exchange_routing","import");
        channel.queueBind("SEND_STATION2","exchange_routing","normal");
        //发送消息          参数一：交换机名    参数二：路由关键字   参数三：其他配置    参数四：发送消息的字节数据
        channel.basicPublish("exchange_routing","import",null,"双十一大促销".getBytes());
        channel.basicPublish("exchange_routing","normal",null,"小促销".getBytes());
        channel.close();
        connection.close();
    }
}
