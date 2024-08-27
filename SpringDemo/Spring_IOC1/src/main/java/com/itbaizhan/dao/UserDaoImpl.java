package com.itbaizhan.dao;

import com.itbaizhan.domin.User;

public class UserDaoImpl implements UserDao{

    public UserDaoImpl(int a) {
    }

    @Override
    public User findUserById(int id) {
        return new User(1,"郭家旗","太原理工大学");
    }
}
