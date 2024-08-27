package com.itbaizhan.service;

import com.itbaizhan.User;
import com.itbaizhan.api.UpdateUserService;
import com.itbaizhan.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 更新用户业务层
 */
@Service
public class UpdateUserServiceImpl implements UpdateUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User preUpdateUsers(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }
}
