package com.itbaizhan.sendmessage;

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
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 延迟消息测试类
 */
public class ScheduleMessageTest {


    /**
     * 延迟消息生产者
     */
    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group");
        producer.setNamesrvAddr("192.168.66.128:9876");
        producer.start();
        Message message = new Message("schedule_topic",
                "", "我是延迟消息".getBytes(StandardCharsets.UTF_8));
        // 设置延迟等级
        // 1到18分别对应messageDelayLevel= 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        message.setDelayTimeLevel(2);
        producer.send(message);
        producer.shutdown();
    }

    /**
     * 延迟消息消费者
     */
    @Test
    public void consumer() throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group");
        consumer.setNamesrvAddr("192.168.66.128:9876");
        consumer.subscribe("schedule_topic","*");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                list.forEach(messageExt -> {
                    System.out.println(new String(messageExt.getBody(),StandardCharsets.UTF_8));
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        Thread.sleep(Long.MAX_VALUE);
    }

}
