package com.itbaizhan.service.impl;

import com.itbaizhan.mapper.UserMapper;
import com.itbaizhan.pojo.User;
import com.itbaizhan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/5
 * @apiNote TODO(一句话给出该类描述)
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users.toString());
        return users;
    }
}
