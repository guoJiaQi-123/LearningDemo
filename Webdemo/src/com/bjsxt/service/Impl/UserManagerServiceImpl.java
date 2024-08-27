package com.bjsxt.service.Impl;

import com.bjsxt.dao.Impl.UserManagerDaoImpl;
import com.bjsxt.dao.UserManagerDao;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserManagerService;

import java.util.List;

/**
 * 用户管理业务层接口实现类
 */
public class UserManagerServiceImpl implements UserManagerService {
    /**
     * 添加用户
     * @param users 将传入的用户添加到数据库中
     */
    @Override
    public void addUser(Users users) {
        UserManagerDao userManagerDao=new UserManagerDaoImpl();
        userManagerDao.insertUser(users);
    }

    /**
     * 查询用户
     * @param users
     * @return 查询到的用户列表
     */
    @Override
    public List<Users> findUser(Users users) {
        UserManagerDao userManagerDao=new UserManagerDaoImpl();
        List<Users> list = userManagerDao.selectUserByProperty(users);
        return list;
    }

    /**
     * 预更新用户
     * @param userid
     * @return
     */
    @Override
    public Users findUserByUserId(int userid) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        return userManagerDao.selectUserByUserId(userid);
    }

    /**
     * 更新用户
     * @param users
     */
    @Override
    public void modifyUser(Users users) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        userManagerDao.updateUserByUserId(users);
    }

    /**
     * 删除用户
     * @param userid
     */
    @Override
    public void deleteUserByUserId(int userid) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        userManagerDao.deleteUserByUserId(userid);
    }


}
