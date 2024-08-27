package com.tyut.test.service.impl;

import com.tyut.test.entity.User;
import com.tyut.test.mapper.UserMapper;
import com.tyut.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @author OldGj 2024/5/7
 * @apiNote 用户业务层实现类
 */
@Service
public class IUserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }
}
