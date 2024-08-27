package com.tyut.test.service;

import com.tyut.test.entity.User;

/**
 * @version v1.0
 * @apiNote TODO(请给出接口描述)
 * @author OldGj 2024/5/7
 */
public interface IUserService {

    User findById(Integer id);

}
