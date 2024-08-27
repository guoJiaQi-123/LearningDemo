package com.bjsxt.advice;


import com.bjsxt.annotation.AnnotationConfig;
import com.bjsxt.annotation.ServiceDemoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@SpringJUnitConfig(classes = AnnotationConfig.class)
@SpringJUnitConfig(locations = "classpath:applicationContext-annotation.xml")
public class AnnotationTest {

    @Autowired
    ServiceDemoImpl serviceDemo;

    @Test
    void test(){
        serviceDemo.demo();
    }

}
