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
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 集群消费模式
 */
public class ConsumerModelTest {


    /**
     * 消息生产者
     */
    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("cluster_producer");
        producer.setNamesrvAddr("192.168.66.128:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("clusterTopic", "", ("clusterConsumer " + i).getBytes(StandardCharsets.UTF_8));
            producer.send(message);
        }
        producer.shutdown();
    }
    /**
     * 集群消费者模式二
     */
    @Test
    public void consumer() throws MQClientException, InterruptedException {
        // 同一集群的消费者在同一个消费者组 clusterConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("clusterConsumer");
        consumer.setNamesrvAddr("192.168.66.128:9876");
        consumer.subscribe("clusterTopic", "*");
        // 集群消费模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
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

    /**
     * 集群消费者模式一
     */
    @Test
    public void consumer2() throws MQClientException, InterruptedException {
        // 同一集群的消费者在同一个消费者组 clusterConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("clusterConsumer");
        consumer.setNamesrvAddr("192.168.66.128:9876");
        consumer.subscribe("clusterTopic", "*");
        // 集群消费模式 MessageModel.CLUSTERING
        consumer.setMessageModel(MessageModel.CLUSTERING);
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

    /**
     * 广播消费者模式二
     */
    @Test
    public void broadcast() throws MQClientException, InterruptedException {
        // 同一集群的消费者在同一个消费者组 clusterConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcastConsumer");
        consumer.setNamesrvAddr("192.168.66.128:9876");
        consumer.subscribe("clusterTopic", "*");
        // 广播消费模式 MessageModel.BROADCASTING
        consumer.setMessageModel(MessageModel.BROADCASTING);
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

    /**
     * 广播消费者模式一
     */
    @Test
    public void broadcast2() throws MQClientException, InterruptedException {
        // 同一集群的消费者在同一个消费者组 clusterConsumer
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcastConsumer");
        consumer.setNamesrvAddr("192.168.66.128:9876");
        consumer.subscribe("clusterTopic", "*");
        // 广播消费模式 MessageModel.BROADCASTING
        consumer.setMessageModel(MessageModel.BROADCASTING);
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
