package com.itbaizhan.service;

import com.itbaizhan.api.DeleteUserService;
import com.itbaizhan.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 删除用户业务层
 */
@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteById(userId);
    }
}
