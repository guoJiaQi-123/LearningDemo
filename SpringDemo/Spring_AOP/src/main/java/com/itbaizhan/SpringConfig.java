package com.itbaizhan;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.itbaizhan")
@EnableAspectJAutoProxy
public class SpringConfig {
}
