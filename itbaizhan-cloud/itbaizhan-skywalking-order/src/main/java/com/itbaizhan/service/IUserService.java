package com.itbaizhan.service;

import com.itbaizhan.pojo.User;

import java.util.List;

/**
 * @version v1.0
 * @apiNote TODO(请给出接口描述)
 * @author OldGj 2024/5/5
 */
public interface IUserService {

    List<User> findAll();

}
