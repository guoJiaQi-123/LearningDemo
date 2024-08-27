package com.itbaizhan.dao;

public class UserDaoFactor2 {

    public static UserDao getUserDao(){
        return new UserDaoImpl(2);
    }
}
