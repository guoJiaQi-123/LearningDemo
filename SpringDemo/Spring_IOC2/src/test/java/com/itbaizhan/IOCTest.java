package com.itbaizhan;

import com.itbaizhan.dao.UserDao;
import com.itbaizhan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");



        UserService userService = (UserService) ac.getBean("userService");


        System.out.println(userService);
    }
    @Test
    public void test2(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = (UserService) ac.getBean("userService");


        System.out.println(userService);
    }
}
