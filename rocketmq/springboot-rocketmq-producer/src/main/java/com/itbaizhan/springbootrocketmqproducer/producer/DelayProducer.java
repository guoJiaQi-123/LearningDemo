package com.itbaizhan.springbootrocketmqproducer.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class DelayProducer {
    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        //实例化生产者									//生产者组
        DefaultMQProducer producer = new DefaultMQProducer("producer_groupp_01");
        //设置要发送的rocketmq名字服务器nameserver地址，
        //生产者需要与nameServer服务器建立长连接以获取broker的信息
        producer.setNamesrvAddr("192.168.66.200:9876");
        //启动生产者
        producer.start();

        Message message = null;
        for (int i = 0; i < 20; i++) {
            //实例化消息对象，传入topic主题和消息内容
            message = new Message("topicTest", ("delayMessage" + i).getBytes());

            //设置消息的延迟级别，在RocketMQ中，消息的延迟级别有18级 其中0代表不延迟，1-18依次对应下面的18个级别
            //"1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h"
            message.setDelayTimeLevel(i);

            //生产者向topic主题中发送消息
            producer.send(message);
        }
        producer.shutdown();
    }
}
