package com.bjsxt.service.Impl;

import com.bjsxt.dao.Impl.UserLoginDaoImpl;
import com.bjsxt.dao.UserLoginDao;
import com.bjsxt.exception.UserNotFoundException;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserLoginService;

/**
 * 用户登录业务
 */
public class UserLoginServiceImpl implements UserLoginService {
    /**
     * 用户登录
     * @param username 用户名
     * @param userpwd 密码
     * @return
     */
    @Override
    public Users userLogin(String username, String userpwd) {
        UserLoginDao userLogin = new UserLoginDaoImpl();
        Users users = userLogin.selectUsersByUserNameAndUserPwd(username, userpwd);
        if(users == null){
            throw new UserNotFoundException("用户名或密码错误");
        }
        return users;
    }
}
