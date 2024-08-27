package com.itbaizhan.springbootrocketmqproducer.producer;


import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

public class GlobalOrderProducer {
    public static void main(String[] args) throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group_01");
        producer.setNamesrvAddr("192.168.66.200:9876");
        producer.start();
        Message message = null;
        for (int i = 0; i < 100; i++) {
            message = new Message("topic_01", ("globalOrderMessage" + i).getBytes());
            producer.send(message, new MessageQueueSelector() {
                /**
                 * @param list 消息队列集合
                 * @param message 消息对象
                 * @param o 消息将要进入的队列下标，它与send方法的第三个参数相同
                 * @return 在队列集合中选择的其中一个消息队列
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    return list.get((Integer) o);
                }
            }, 1);
        }
        producer.shutdown();
    }
}
