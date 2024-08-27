package com.itbaizhan.springbootrocketmqproducer.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

public class AsyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        //实例化生产者
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //设置要发送的rocketmq名字服务器nameserver地址，生产者需要与nameServer服务器建立长连接以获取broker的信息
        producer.setNamesrvAddr("192.168.66.200:9876");
        //启动生产者
        producer.start();
        //设置当异步消息发送失败，重试的次数
        producer.setRetryTimesWhenSendAsyncFailed(0);
        //设置定时器次数
        int count = 100;
        // 根据消息数量实例化倒计时计算器
        CountDownLatch2 countDownLatch2 = new CountDownLatch2(count);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Message message = new Message(
                    "topicTest",
                    "TagA",
                    "order188",
                    ("hello AsyncRocketmq").getBytes(RemotingHelper.DEFAULT_CHARSET));
            // SendCallback接收异步返回结果的回调
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch2.countDown();
                    System.out.println(index + " - message  - ok " + sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable throwable) {
                    countDownLatch2.countDown();
                    System.out.println(index + " -  message  -exception " + throwable);
                    throwable.printStackTrace();
                }
            });

        }
        //最多等待5s内计数器如果没有操作
        countDownLatch2.await(5, TimeUnit.SECONDS);
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
