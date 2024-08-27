package com.itbaizhan.dao;


import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void add(){
        System.out.println("新增用户");
    }
    public void delete(){
        System.out.println("删除用户");
    }
    public void update(){
        System.out.println("修改用户");
    }
}
