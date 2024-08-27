package com.itbaizhan.dao;

import com.itbaizhan.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest2 {


    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        UserDao userDao = (UserDao) ac.getBean("userDaoProxy");
        userDao.delete();
    }
    @Test
    public void testAdd2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao"); // 获取的是代理对象
        userDao.update();
    }


}
