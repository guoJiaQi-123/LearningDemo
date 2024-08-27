package com.itbaizhan.sendmessage;

import com.itbaizhan.domain.Order;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 局部顺序消息
 */
public class PartOrderMessageTest {


    /**
     * 消息创建者-局部消息
     */
    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // 初始化生产者
        DefaultMQProducer producer = new DefaultMQProducer("producer");
        // 设置nameserver地址
        producer.setNamesrvAddr("192.168.66.128:9876");
        // 启动生产者
        producer.start();
        // 获取订单对象
        List<Order> orders = getOrders();
        for (Order order : orders) {
            // 创建消息对象
            Message message = new Message("jubu_message_topic", "", order.toString().getBytes(StandardCharsets.UTF_8));
            // 发送消息
            /*
             * message：消息对象
             * selector：消息队列的选择器
             * arg：选择队列的业务标识,如本例中的orderId
             */
            producer.send(message, new MessageQueueSelector() {
                /**
                 * @param mqs 队列集合
                 * @param message 消息对象
                 * @param args 业务标识的参数，对应send()方法传入的第三个参数arg
                 */
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message message, Object args) {
                    // MessageQueueSelector 队列选择器，根据你参数三传入的参数，指定选择队列的策略
                    return mqs.get((int) ((Long) args % mqs.size()));
                }
                // 参数三：根据什么去选择队列
                //  mqProducer.send()方法第三个参数, 会传递到select()方法的arg参数
            }, order.getOrderId());
        }
        // 关闭生产者
        producer.shutdown();
    }

    // 订单状态变更流程:   订单创建 ->  订单支付 -> 订单完成
    List<Order> getOrders() {
        List<Order> list = new ArrayList<>();
        Order order = new Order();
        order.setOrderId(1L);
        order.setOrderStatus("订单创建");
        list.add(order);

        order = new Order();
        order.setOrderId(1L);
        order.setOrderStatus("订单支付");
        list.add(order);

        order = new Order();
        order.setOrderId(2L);
        order.setOrderStatus("订单创建");
        list.add(order);

        order = new Order();
        order.setOrderId(1L);
        order.setOrderStatus("订单完成");
        list.add(order);

        order = new Order();
        order.setOrderId(2L);
        order.setOrderStatus("订单支付");
        list.add(order);

        order = new Order();
        order.setOrderId(2L);
        order.setOrderStatus("订单完成");
        list.add(order);

        return list;

    }

    /**
     * 消息生产者 - 局部顺序消息
     */
    @Test
    public void consumer() throws MQClientException, InterruptedException {
        // 创建DefaultMQPushConsumer类并设定消费者名称
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producer");
        // 设置NameServer地址，如果是集群的话，使用分号;分隔开
        consumer.setNamesrvAddr("192.168.66.128:9876");
        // 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        // 如果不是第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息，如果订阅该主题下的所有tag，则使用*
        consumer.subscribe("jubu_message_topic", "*");
        // 注册回调实现类来处理从broker拉取回来的消息
        // 注意：顺序消息注册的是MessageListenerOrderly监听器
        consumer.setMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                consumeOrderlyContext.setAutoCommit(true);
                for (MessageExt msg : list) {
                    // 每个queue有唯一的consume线程来消费, 订单对每个queue都是分区有序
                    System.out.println("消费线程=" + Thread.currentThread().getName() +
                            ", queueId=" + msg.getQueueId() + ", 消息内容:" + new String(msg.getBody(),StandardCharsets.UTF_8));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        // 启动消费者
        consumer.start();
        Thread.sleep(Long.MAX_VALUE);
    }


}
