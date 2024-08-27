package com.bjsxt.advice;

import com.bjsxt.service.ServiceDemo;
import com.bjsxt.service.impl.ServiceDemoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig()
@ContextConfiguration(locations = "classpath:applicationContext.xml")
class MyBeforeAdviceTest {

    // 注入服务
    @Autowired
    ServiceDemo serviceDemo;

    @Test
    void before() {
        // 调用a方法
        serviceDemo.a();
        // 调用b方法
        serviceDemo.b();
        // 调用c方法
        serviceDemo.c();
    }
}