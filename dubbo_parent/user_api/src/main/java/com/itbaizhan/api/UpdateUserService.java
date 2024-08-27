package com.itbaizhan.api;


import com.itbaizhan.User;

/**
 * 用户更新接口
 */
public interface UpdateUserService {

    //根据id查询用户
    User preUpdateUsers(Long userId);

    //根据用户id更新用户
    int updateUser(User user);

}
