package com.itbaizhan.dao;

import com.itbaizhan.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    @Test
    public void testAdd(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.add();
    }

    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.delete();
    }

    @Test
    public void testUpdate(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = (UserDao) ac.getBean("userDao");
        userDao.update();
    }
}
