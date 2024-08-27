package com.itbaizhan.service;


import com.itbaizhan.User;
import com.itbaizhan.api.AddUserService;
import com.itbaizhan.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 添加用户业务
 */
@Service
public class AddUserServiceImpl implements AddUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
