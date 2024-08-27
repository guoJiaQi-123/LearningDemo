package com.itbaizhan.dao;

public class UserDaoFactor {

    public UserDao getUserDao(){
        return new UserDaoImpl(1);
    }
}
