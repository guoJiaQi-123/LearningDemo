package com.itbaizhan.springbootrocketmqproducer.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionProducer {
    public static void main(String[] args) throws MQClientException {

        TransactionListener transactionListener = new TransactionListener() {
            //执行本地事务方法
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                System.out.println("执行本地事务");
                //模拟生产者由于某种原因无法向broker服务端发送事务确认消息
                //broker服务器隔一段时间没有收到确认消息会向生产者发送消息回查信息
                //这是RockerMQ对于事务消息2PC思想的一个补偿逻辑，用于处理二阶段消息发送失败或超时
                try {
                    Thread.sleep(1000*10*10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }

            //回查本地事务方法
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                System.out.println("执行回查事务");
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        };

        TransactionMQProducer producer = new TransactionMQProducer("TransactionProducer_group_01");
        producer.setNamesrvAddr("192.168.66.200:9876");
        producer.setTransactionListener(transactionListener);

        producer.start();
        Message message = new Message("topicTest", "事务消息".getBytes());
        producer.sendMessageInTransaction(message,"{\"name\":\"zhangsan\"}");
        producer.shutdown();
    }
}
