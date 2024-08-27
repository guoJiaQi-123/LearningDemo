package com.bjsxt.dao;

import com.bjsxt.pojo.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户管理持久层接口
 */
public interface UserManagerDao {
    //添加用户接口
    public void insertUser(Users users);
    //查询用户接口
    List<Users> selectUserByProperty(Users users);
    //预更新用户接口
    Users selectUserByUserId(int userid);
    //更新用户接口
    void updateUserByUserId(Users users);
    //删除用户接口
    void deleteUserByUserId(int userid);
}
