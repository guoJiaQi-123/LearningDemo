package com.bjsxt.advice;

import com.bjsxt.service.ServiceDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:applicationContext-Aspectj.xml")
public class AspectJTest {
    // 注入ServiceDemo对象
    @Autowired
    ServiceDemo serviceDemo;

    // 测试方法
    @Test
    void test(){
        // 调用ServiceDemo对象的b方法
        serviceDemo.b();
    }
}