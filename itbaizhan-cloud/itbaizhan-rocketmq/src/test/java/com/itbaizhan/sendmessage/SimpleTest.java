package com.itbaizhan.sendmessage;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/1
 * @apiNote 发送简单消息
 */
@Slf4j
public class SimpleTest {

    /**
     * 消息生产者
     */
    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 1. 初始化生产者
        DefaultMQProducer producer = new DefaultMQProducer("producer");
        // 2. 设置mq地址
        producer.setNamesrvAddr("192.168.66.128:9876");
        // 3. 启动生产者
        producer.start();
        // 4. 创建消息对象  参数一：主题   参数二：标记过滤   参数三：消息体
        Message message = new Message("SimpleTest", "tags", "hello rocketmq".getBytes(StandardCharsets.UTF_8));
        // 5. 发送消息
        SendResult sendResult = producer.send(message);
        // 6. 打印结果并且关闭消费者
        System.out.println(sendResult);
        producer.shutdown();
    }

    /**
     * 消息消费者
     */
    @Test
    public void consumer() throws MQClientException, InterruptedException {
        // 1. 初始化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producer");
        // 2. 为消费者设置mq地址
        consumer.setNamesrvAddr("192.168.66.128:9876");
        // 3. 订阅主题
        consumer.subscribe("SimpleTest", "*");
        // 4. 注册消息监听器 消费消息
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : msgList) {
                    System.out.println(new String(messageExt.getBody(), StandardCharsets.UTF_8));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 5. 启动消费者
        consumer.start();
        // 6. 使程序一直运行
        Thread.sleep(Long.MAX_VALUE);
    }


}
