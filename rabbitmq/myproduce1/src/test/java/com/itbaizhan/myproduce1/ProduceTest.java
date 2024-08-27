package com.itbaizhan.myproduce1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProduceTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    @DisplayName("测试确认模式")
    void testConfirm(){

        //定义确认模式的回调函数
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * 回调方法
             * @param correlationData 相关配置
             * @param b 是否成功将消息发送给交换机
             * @param s 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                if(b){
                    System.out.println("消息发送成功");
                }else {
                    System.out.println("消息发送失败，原因："+s);
                    //其他操作
                }
            }
        });

        rabbitTemplate.convertAndSend("my_topic_exchange","my_routing","send message");
    }

    @Test
    @DisplayName("测试退回模式")
    void testReturn(){
        // 定义退回模式的回调方法。交换机发送消息到队列失败后才会执行returnedMessage方法
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            /**
             * @param returned 失败后将失败信息封装到参数中
             */
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                System.out.println("错误码："+returned.getReplyCode());
                System.out.println("错误信息："+returned.getReplyText());
                System.out.println("交换机："+returned.getExchange());
                System.out.println("路由键："+returned.getRoutingKey());
                System.out.println("交换机："+returned.getExchange());
                // 处理消息...
            }
        });


        rabbitTemplate.convertAndSend("my_topic_exchange","my_routing2","send message");

    }

    @Test
    @DisplayName("批量发送消息")
    void testBatchSend(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("my_topic_exchange","my_routing",("message"+i));

        }
    }

    @Test
    @DisplayName("批量发送消息")
    void testBatchSend2(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("my_topic_exchange2","my_routing",("message"+i));

        }
    }

    @Test
    @DisplayName("发送设置失效时间的消息")
    void testBatchSend3(){

        for (int i = 0; i < 10; i++) {
            if(i==5){
                //1.实例化消息属性对象
                MessageProperties messageProperties = new MessageProperties();
                //2.设置失效时间
                messageProperties.setExpiration("10000");//消息10秒失效
                //3.实例化消息
                Message message = new Message(("message"+i).getBytes(), messageProperties);
                //4.发送消息
                rabbitTemplate.convertAndSend("my_topic_exchange","my_routing",message);
            }else {
                rabbitTemplate.convertAndSend("my_topic_exchange","my_routing","message"+i);
            }
        }


    }

    @Test
    @DisplayName("发送带有优先级的消息")
    void PriorityTest(){
        for (int i = 0; i < 10; i++) {
            if(i==5){
                //实例化消息属性对象
                MessageProperties messageProperties = new MessageProperties();
                //设置优先级
                messageProperties.setPriority(9);
                //实例化消息对象
                Message message = new Message(("message"+i).getBytes(),messageProperties);
                //发送消息
                rabbitTemplate.convertAndSend("priority_exchange","my_routing",message);
            }else {
                rabbitTemplate.convertAndSend("priority_exchange","my_routing","message"+i);
            }
        }
    }

    @Test
    @DisplayName("测试死信队列")
    void testDeadQueue(){
        // 1.当消息到达消息存活时间，队列中的消息失效，被发送到死信队列
        // rabbitTemplate.convertAndSend("normal_exchange","my_routing","测试死信队列");
/*
        2.当发送的消息个数超过队列的长度，则超出部分发送到死信队列
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("normal_exchange","my_routing","测试");
        }
*/
        // 3.当消息被消费者拒签且不退回原来队列时，拒签消息被发送到死信队列
        rabbitTemplate.convertAndSend("normal_exchange","my_routing","测试死信队列");
    }

}
