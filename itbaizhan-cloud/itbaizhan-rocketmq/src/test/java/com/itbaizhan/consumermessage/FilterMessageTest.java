package com.itbaizhan.consumermessage;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 过滤消息测试类
 */
public class FilterMessageTest {


    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("filter_producer");
        producer.setNamesrvAddr("192.168.66.128:9876");
        producer.start();
        List<String> tagList = List.of("a", "b", "c", "d");
        for (String tag : tagList) {
            Message message = new Message("filter_topic", tag, ("hello filter tag message " + tag).getBytes(StandardCharsets.UTF_8));
            producer.send(message);
        }
        producer.shutdown();
    }

    @Test
    public void consumer() throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("filter_consumer");
        consumer.setNamesrvAddr("192.168.66.128:9876");
        consumer.subscribe("filter_topic", "c");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach(messageExt -> {
                    System.out.println(new String(messageExt.getBody(), StandardCharsets.UTF_8));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        Thread.sleep(Long.MAX_VALUE);
    }


}
