package com.itbaizhan.api;

import com.itbaizhan.User;

import java.util.List;

/**
 * 查询用户
 */
public interface FindUserService {

    /**
     * 查询全部用户
     * @return 全部用户集合
     */
    List<User> findAllUser();
}
