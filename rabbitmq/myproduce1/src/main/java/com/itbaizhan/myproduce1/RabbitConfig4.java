package com.itbaizhan.myproduce1;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig4 {

    private final String DEAD_EXCHANGE = "dead_exchange";
    private final String DEAD_QUEUE = "dead_queue";

    private final String NORMAL_EXCHANGE = "normal_exchange";
    private final String NORMAL_QUEUE = "normal_queue";


    //创建死信交换机
    @Bean(name = DEAD_EXCHANGE)
    public Exchange getExchange() {
        return ExchangeBuilder
                .topicExchange(DEAD_EXCHANGE)
                .durable(true)
                .build();
    }

    //创建死信队列
    @Bean(name = DEAD_QUEUE)
    public Queue getQueue() {
        return QueueBuilder
                .durable(DEAD_QUEUE)
                .build();
    }

    //绑定死信交换机和死信队列
    @Bean
    public Binding bindDeadQueue(@Qualifier(DEAD_EXCHANGE) Exchange exchange,
                                 @Qualifier(DEAD_QUEUE) Queue queue) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("dead_routing")
                .noargs();
    }

    //创建普通交换机
    @Bean(name = NORMAL_EXCHANGE)
    public Exchange normalExchange() {
        return ExchangeBuilder
                .topicExchange(NORMAL_EXCHANGE)
                .durable(true)
                .build();
    }

    //创建普通队列
    @Bean(name = NORMAL_QUEUE)
    @SuppressWarnings("all")
    public Queue normalQueue() {
        return QueueBuilder
                .durable(NORMAL_QUEUE)
                .deadLetterExchange(DEAD_EXCHANGE)//给普通队列绑定死信交换机
                .deadLetterRoutingKey("dead_routing")//死信交换机和死信队列的绑定路由关键字
                .maxLength(10)//队列最大长度10
                .ttl(10000)//消息存活时间10秒
                .build();
    }

    //绑定普通交换机和普通队列
    @Bean
    public Binding bindNormalQueue(@Qualifier(NORMAL_EXCHANGE) Exchange exchange,
                                   @Qualifier(NORMAL_QUEUE) Queue queue) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("my_routing")
                .noargs();

    }


}
