package com.itbaizhan.myshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.myshiro.domain.Permission;
import com.itbaizhan.myshiro.domain.Users;

import java.util.List;


public interface UsersMapper extends BaseMapper<Users> {

    //根据用户id查询用户权限
    List<Permission> findPermissionByUserId(int id);
}
