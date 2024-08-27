package com.bjsxt.annotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//配置类
@Configuration
@ComponentScan("com.bjsxt.annotation")
@EnableAspectJAutoProxy
public class AnnotationConfig {

}
