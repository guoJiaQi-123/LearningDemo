package com.itbaizhan.sendmessage;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 单向消息
 */
public class OneWayMessageTest {

    /**
     * 单向消息生产者
     */
    @Test
    public void producer() throws MQClientException, RemotingException, InterruptedException {
        // 创建消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("oneway_producer");
        // 为生产者设置mq地址
        producer.setNamesrvAddr("192.168.66.128:9876");
        // 启动生产者
        producer.start();
        // 创建消息体
        Message message = new Message("oneway_topic", "", "hello oneWay".getBytes(StandardCharsets.UTF_8));
        // 发送单向消息  sendOneway();
        producer.sendOneway(message);
        // 关闭生产者实例
        producer.shutdown();
    }

    /**
     * 单向消息消费者
     */
    @Test
    public void consumer() throws MQClientException, InterruptedException {
        // 创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("oneway_consumer");
        // 设置mq地址
        consumer.setNamesrvAddr("192.168.66.128:9876");
        // 订阅主题
        consumer.subscribe("oneway_topic", "*");
        // 设置消息监听
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println(new String(messageExt.getBody(), StandardCharsets.UTF_8));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 开启消费者
        consumer.start();
        // 程序永久运行
        Thread.sleep(Long.MAX_VALUE);
    }


}
