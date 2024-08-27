package com.itbaizhan.service;

import com.itbaizhan.dao.UserDao;
import com.itbaizhan.dao.UserDaoImpl;
import com.itbaizhan.domin.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UserService {
    private UserDao userDao; // bean属性
    private String name; //字符串类型
    private int count; //基本数据类型
    private List<String> names; // 字符串类型List集合
    private List<User> users1; // 对象类型List集合
    private Set<User> users2; // 对象类型Set集合
    private Map<String,String> names2; // 字符串类型Map集合
    private Map<String,User> users3; // 对象类型Map集合
    private Properties properties; //Properties类型

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", names=" + names +
                ", users1=" + users1 +
                ", users2=" + users2 +
                ", names2=" + names2 +
                ", users3=" + users3 +
                ", properties=" + properties +
                '}';
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<User> getUsers1() {
        return users1;
    }

    public void setUsers1(List<User> users1) {
        this.users1 = users1;
    }

    public Set<User> getUsers2() {
        return users2;
    }

    public void setUsers2(Set<User> users2) {
        this.users2 = users2;
    }

    public Map<String, String> getNames2() {
        return names2;
    }

    public void setNames2(Map<String, String> names2) {
        this.names2 = names2;
    }

    public Map<String, User> getUsers3() {
        return users3;
    }

    public void setUsers3(Map<String, User> users3) {
        this.users3 = users3;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public UserService() {
    }

    public UserService(UserDao userDao, String name, int count, List<String> names, List<User> users1, Set<User> users2, Map<String, String> names2, Map<String, User> users3, Properties properties) {
        this.userDao = userDao;
        this.name = name;
        this.count = count;
        this.names = names;
        this.users1 = users1;
        this.users2 = users2;
        this.names2 = names2;
        this.users3 = users3;
        this.properties = properties;
    }

    public User getUserById(int i) {
        return userDao.findUserById(i);
    }
}
