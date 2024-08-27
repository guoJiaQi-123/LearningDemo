package com.itbaizhan.mysecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itbaizhan.mysecurity.domain.Permission;
import com.itbaizhan.mysecurity.domain.Users;
import com.itbaizhan.mysecurity.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//自定义SpringSecurity认证逻辑，从 数据库 获取用户信息判断
@Service
@SuppressWarnings("all")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.创造查询条件
        QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>().eq("username", username);
        //2.查询用户
        Users users = usersMapper.selectOne(queryWrapper);
        if(users==null){
            return null;
        }
        //3.根据查询到的用户查询该用户拥有的权限
        List<Permission> permissions = usersMapper.findPermissionByUserName(username);
        //4.把查询到的自定义权限对象转换为Security自带的权限对象
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission permission : permissions) {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getUrl()));
        }
        //5.将查询到的用户信息封装到UserDetails对象中
        UserDetails userDetails = User.withUsername(users.getUsername())
                .password(users.getPassword())
                .authorities(grantedAuthorities)
                .build();

        //6.返回封装好的UserDetails对象
        return userDetails;
    }
}
