package com.itbaizhan.springbootdemo1;

import com.itbaizhan.springbootdemo1.listener.SecondListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean(){
        ServletListenerRegistrationBean<SecondListener> registrationBean = new ServletListenerRegistrationBean<>(new SecondListener());
        return registrationBean;
    }
}
