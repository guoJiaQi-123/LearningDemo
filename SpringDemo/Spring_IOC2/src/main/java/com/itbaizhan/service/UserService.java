package com.itbaizhan.service;

import com.itbaizhan.dao.UserDao;
import com.itbaizhan.dao.UserDaoImpl;
import com.itbaizhan.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Scope("singleton")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Value("郭家旗")
    private String name;

    @Value("20")
    private int age;


    @Value("${jdbc.username}")
    private String databaseUsername;

    @Value("${jdbc.password}")
    private String databasePassword;


    public UserDao getUserDao() {
        return userDao;
    }


    public UserService() {
    }


    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserById(int id){
        return userDao.findUserById(id);
    }


    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", databaseUsername='" + databaseUsername + '\'' +
                ", databasePassword='" + databasePassword + '\'' +
                '}';
    }
}
