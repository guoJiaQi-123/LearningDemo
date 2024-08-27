package com.itbaizhan.springbootrocketmqproducer.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DelayConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group_01");
        consumer.setNamesrvAddr("192.168.66.200:9876");
        consumer.subscribe("topicTest", "*");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                for (MessageExt msg : list) {
                    System.out.println("时间：" + dateFormat.format(new Date()) + "\t" +
                            "消息所处队列：" + msg.getQueueId() + "\t" +
                            "消息延迟级别：" + msg.getDelayTimeLevel() + "\t" +
                            "消息内容：" + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
