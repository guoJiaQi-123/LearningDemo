package com.itbaizhan.springbootrocketmqproducer.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class OnewayProducer {
    public static void main(String[] args) throws UnsupportedEncodingException, MQClientException, RemotingException, InterruptedException {
        //创建生产者实例
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //为生产者设置NameServer服务器地址 生产者需要与NameServer建立长连接获取broker信息
        producer.setNamesrvAddr("192.168.66.200:9876");
        //启动生产者
        producer.start();
        for (int i = 0; i < 100; i++) {
            //实例化消息对象
            Message message = new Message(
                    "topicTest",//topic
                    "TagA",//Tag
                    ("hello rocketmq oneway" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));//body
            //发送单向消息
            producer.sendOneway(message);
        }
        //关闭生产者实例
        producer.shutdown();
    }

}
