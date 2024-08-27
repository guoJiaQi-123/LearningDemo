package com.itbaizhan.service;

import com.itbaizhan.User;

import java.util.List;

/**
 * 用户业务层
 */
public interface UserService {

    //添加用户
    int addUser(User user);


    //查询用户
    List<User> findAllUser();

    //更新用户
    //根据id查询用户
    User preUpdateUsers(Long userId);

    //根据用户id更新用户
    int updateUser(User user);

    //删除用户
    void deleteUserById(Long userId);
}
