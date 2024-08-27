package com.bjsxt.dao;

import com.bjsxt.pojo.Users;

/**
 * 用户登录持久层接口
 */
public interface UserLoginDao {
    //根据用户名和用户名密码查询用户接口
    public Users selectUsersByUserNameAndUserPwd(String username,String userpwd);
}
