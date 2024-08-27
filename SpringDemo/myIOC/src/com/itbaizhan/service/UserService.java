package com.itbaizhan.service;

import com.itbaizhan.Container;
import com.itbaizhan.dao.UserDao;
import com.itbaizhan.dao.UserDaoImpl;
import com.itbaizhan.domin.User;

public class UserService {

    /*public static void findUserById(){
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById(1);
        System.out.println(user);
    }*/

    public void findUserById(){
        // 从容器中获取对象
        UserDaoImpl userDao = (UserDaoImpl) Container.getBean("UserDao");
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
