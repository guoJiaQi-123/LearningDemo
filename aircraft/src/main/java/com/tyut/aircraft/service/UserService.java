package com.tyut.aircraft.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyut.aircraft.mapper.UserMapper;
import com.tyut.aircraft.pojo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    BCryptPasswordEncoder encoder;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //根据管理员名字查询管理员
    public User findUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }


    /**
     * 用户注册
     * @param user
     */
    public void register(User user) {
        String password = user.getPassword(); // 获取密码
        String encodePassword = encoder.encode(password); // 加密器加密密码
        user.setPassword(encodePassword); // 设置加密后密码
        userMapper.insert(user); // 持久化数据库
    }

}
