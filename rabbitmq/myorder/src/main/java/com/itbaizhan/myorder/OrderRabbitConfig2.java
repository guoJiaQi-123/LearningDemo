package com.itbaizhan.myorder;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OrderRabbitConfig2 {

    private final String DELAYED_EXCHANGE="delayed_exchange";
    private final String DELAYED_QUEUE="delayed_queue";

    @Bean(DELAYED_EXCHANGE)
    public Exchange delayedExchange(){

        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "topic"); // topic类型的延迟交换机
        return new CustomExchange(DELAYED_EXCHANGE,"x-delayed-message",true,false,args);
    }

    //2.延迟队列
    @Bean(DELAYED_QUEUE)
    public Queue delayedQueue() {
        return QueueBuilder
                .durable(DELAYED_QUEUE)
                .build();
    }

    @Bean
    public Binding bindingDelayedQueue(@Qualifier(DELAYED_EXCHANGE)Exchange exchange,
                                       @Qualifier(DELAYED_QUEUE)Queue queue){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("order_routing")
                .noargs();
    }
}
