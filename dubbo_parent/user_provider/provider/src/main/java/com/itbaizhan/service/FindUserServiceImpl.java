package com.itbaizhan.service;


import com.itbaizhan.User;
import com.itbaizhan.api.FindUserService;
import com.itbaizhan.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 查询用户业务层
 */
@Service
public class FindUserServiceImpl implements FindUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.selectList(null);
    }
}
