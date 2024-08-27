package com.itbaizhan.springbootrocketmqproducer.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.w3c.dom.ranges.Range;

import java.util.List;

public class GlobalOrderConsumer {
    public static void main(String[] args) throws MQClientException {
        //实例化消费者对象
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group_01");
        //消费者连接NameServer服务器
        //消费者和生产者都需要与NameServer建立长连接以获取broker信息
        consumer.setNamesrvAddr("192.168.66.200:9876");
        //消费者订阅主题
        consumer.subscribe("topic_01", "*");

        //设置最小消费线程数为1
        consumer.setConsumeThreadMin(1);
        //最大消费线程数为1
        consumer.setConsumeThreadMax(1);
        //一次性最多可以从队列中pull1条消息
        consumer.setPullBatchSize(1);
        //一次消费消息数最大为1
        consumer.setConsumeMessageBatchMaxSize(1);

        //设置消费者消息监听器
        //需要实现有序消费MessageListenerOrderly接口重写consumeMessage方法
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt msg : list) {
                    //拿到消息，打印消费消息线程，消息所属的队列id，消息本身
                    System.out.println(
                            "消费线程：" + Thread.currentThread().getName() + "\t" +
                                    "消费队列：" + msg.getQueueId() + "\t" +
                                    "消息：" + new String(msg.getBody()));
                }
                //返回接收消息成功
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        //启动消费者，监听订阅的主题
        consumer.start();
    }
}
