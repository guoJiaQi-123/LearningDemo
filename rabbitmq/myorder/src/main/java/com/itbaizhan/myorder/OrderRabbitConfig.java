package com.itbaizhan.myorder;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class OrderRabbitConfig {

    private final String ORDER_EXCHANGE = "order_exchange";
    private final String ORDER_QUEUE = "order_queue";

    private final String EXPIRE_EXCHANGE = "expire_exchange";
    private final String EXPIRE_QUEUE = "expire_queue";


    @Bean(EXPIRE_EXCHANGE)
    public Exchange expireExchange(){
        return ExchangeBuilder
                .topicExchange(EXPIRE_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean(EXPIRE_QUEUE)
    public Queue expireQueue(){
        return QueueBuilder
                .durable(EXPIRE_QUEUE)
                .build();
    }

    @Bean
    public Binding bindingExpireQueue(@Qualifier(EXPIRE_EXCHANGE)Exchange exchange,
                                      @Qualifier(EXPIRE_QUEUE)Queue queue){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("expire_routing")
                .noargs();
    }

    @Bean(ORDER_EXCHANGE)
    public Exchange orderExchange(){
        return ExchangeBuilder
                .topicExchange(ORDER_EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean(ORDER_QUEUE)
    public Queue orderQueue(){
        return QueueBuilder
                .durable(ORDER_QUEUE)
                .ttl(1000*10)
                .deadLetterExchange(EXPIRE_EXCHANGE)
                .deadLetterRoutingKey("expire_routing")
                .build();
    }

    @Bean
    public Binding bindingOrderQueue(@Qualifier(ORDER_EXCHANGE)Exchange exchange,
                                     @Qualifier(ORDER_QUEUE)Queue queue){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("order_routing")
                .noargs();

    }

}
