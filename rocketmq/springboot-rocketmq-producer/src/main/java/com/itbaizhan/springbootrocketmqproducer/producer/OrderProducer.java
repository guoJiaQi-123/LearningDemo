package com.itbaizhan.springbootrocketmqproducer.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

public class OrderProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //实例化生产者对象
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //给生产者对象设置NameServer服务器地址
        producer.setNamesrvAddr("192.168.66.200:9876");
        //开启生产者
        producer.start();
        //获取指定主题下的所有MQ
        List<MessageQueue> queueList = producer.fetchPublishMessageQueues("topicTest");
        //定义一个消息变量
        Message message = null;
        //定义一个消息队列变量
        MessageQueue messageQueue = null;
        for (int i = 0; i < 100; i++) {
            // 取模法，采用轮询的方式指定MQ，发送订单消息，保证同一个订单的消息按顺序发送到同一队列
            messageQueue = queueList.get(i % 4);
            //发送消息创建 使用 销毁  且同一个消息下的创建 使用 销毁只能按顺序发送到同一个队列中
            message = new Message("topicTest", ("message_creat" + i).getBytes());
            producer.send(message, messageQueue);

            message = new Message("topicTest", ("message_use" + i).getBytes());
            producer.send(message, messageQueue);

            message = new Message("topicTest", ("message_destroy" + i).getBytes());
            producer.send(message, messageQueue);
        }
        //关闭生产者实例
        producer.shutdown();
    }
}
