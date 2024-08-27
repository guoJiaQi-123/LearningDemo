package com.bjsxt.service;

import com.bjsxt.pojo.Users;

import java.util.List;

/**
 * 用户管理业务层接口
 */
public interface UserManagerService {
    //添加用户
    void addUser(Users users);
    //查询用户
    List<Users> findUser(Users users);
    //预更新用户
    Users findUserByUserId(int userid);
    //更新用户
    void modifyUser(Users users);
    //删除用户
    void deleteUserByUserId(int userid);
}
