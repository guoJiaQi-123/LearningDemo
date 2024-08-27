package com.itbaizhan;

import com.itbaizhan.domin.User;
import com.itbaizhan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {
    @Test
    public void test1(){
        //获取Spring容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //从容器中获取已经实例化好的对象
        UserService userService = (UserService) ac.getBean("userService");
        User user = userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void test2(){
        //获取Spring容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean1.xml");
        //从容器中获取已经实例化好的对象
        UserService userService = (UserService) ac.getBean("userService");

        System.out.println(userService);
    }

}
