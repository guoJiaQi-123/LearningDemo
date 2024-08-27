package com.itbaizhan.mysecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itbaizhan.mysecurity.domain.Permission;
import com.itbaizhan.mysecurity.domain.Users;

import java.util.List;


public interface UsersMapper extends BaseMapper<Users> {

    //根据用户名查询用户权限
    List<Permission> findPermissionByUserName(String username);

}
