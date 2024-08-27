package com.itbaizhan.sendmessage;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 全局顺序消费测试类
 */
public class GlobalOrderMessageTest {

    /**
     * 全局顺序消息生产者
     */
    @Test
    public void globalProducer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 创建DefaultMQProducer类并设定生产者名称
        DefaultMQProducer producer = new DefaultMQProducer("global_producer");
        // 设置NameServer地址，如果是集群的话，使用分号;分隔开
        producer.setNamesrvAddr("192.168.66.128:9876");
        // 启动生产者
        producer.start();

        for (int i = 0; i < 10; i++) {
            // 创建消息
            Message message = new Message("global_message_topic",
                    "",
                    ("全局顺序消息" + i).getBytes(StandardCharsets.UTF_8));
            // 发生消息  （1）消息体  （2） 消息队列选择器  （指定那个消息队列）
            producer.send(message, new MessageQueueSelector() {
                @Override // （1）消息队列集合  （2） 消息体 （3） 指定哪个消息队列
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    return list.get((Integer) o);
                }
            }, 3);
        }
        // 如果不再发送消息，关闭Producer实例
        producer.shutdown();
    }

    /**
     * 全局顺序消息消费者
     */
    @Test
    public void consumer() throws MQClientException, InterruptedException {
        // 创建DefaultMQPushConsumer类并设定消费者名称
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("global_consumer");
        // 设置NameServer地址，如果是集群的话，使用分号;分隔开
        consumer.setNamesrvAddr("192.168.66.128:9876");
        // 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        // 如果不是第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息，如果订阅该主题下的所有tag，则使用*
        consumer.subscribe("global_message_topic", "*");
        /*
         * 与普通消费一样需要注册消息监听器,但是传入的不再是MessageListenerConcurrently
         * 而是需要传入MessageListenerOrderly的实现子类，并重写consumeMessage方法。
         */
        // 顺序消费同一个队列的消息
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext context) {
                for (MessageExt messageExt : list) {
                    System.out.println("消息队列：" + messageExt.getQueueId() +
                                    " 消息体：" + new String(messageExt.getBody(), StandardCharsets.UTF_8));
                }
                // 标记该消息已经被成功消费
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        // 启动消费者实例
        consumer.start();
        // 程序永久运行
        Thread.sleep(Long.MAX_VALUE);
    }

}
