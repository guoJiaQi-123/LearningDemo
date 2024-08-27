package com.itbaizhan.service.impl;

import com.itbaizhan.User;
import com.itbaizhan.api.AddUserService;
import com.itbaizhan.api.DeleteUserService;
import com.itbaizhan.api.FindUserService;
import com.itbaizhan.api.UpdateUserService;
import com.itbaizhan.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Reference
    private AddUserService addUserService;

    @Reference
    private FindUserService findUserService;

    @Reference
    private UpdateUserService updateUserService;

    @Reference
    private DeleteUserService deleteUserService;

    /**
     * 添加用户
     */
    @Override
    public int addUser(User user) {
        return addUserService.addUser(user);
    }

    /**
     * 查询用户
     *
     * @return 所有用户
     */
    @Override
    public List<User> findAllUser() {
        return findUserService.findAllUser();
    }


    /**
     * 更新用户
     */
    @Override
    public User preUpdateUsers(Long userId) {
        return updateUserService.preUpdateUsers(userId);
    }

    @Override
    public int updateUser(User user) {
        return updateUserService.updateUser(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        deleteUserService.deleteUser(userId);
    }

}
