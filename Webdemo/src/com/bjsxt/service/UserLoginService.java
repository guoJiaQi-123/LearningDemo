package com.bjsxt.service;

import com.bjsxt.pojo.Users;

/**
 * 用户登录业务层接口
 */
public interface UserLoginService {
    public Users userLogin(String username,String userpwd);
}
