package com.itbaizhan.service;

import com.itbaizhan.dao.UserDaoImpl;
import com.itbaizhan.domin.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {

    public User findUserById(int id){
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        UserDaoImpl userDao = (UserDaoImpl) ac.getBean("UserDao");
        User user = userDao.findUserById(id);
        return user;
    }

}
