package com.itbaizhan.dao;

import com.itbaizhan.domin.User;
import org.springframework.stereotype.Repository;

//@Component("userDao")
@Repository
public class UserDaoImpl2 implements UserDao {





    @Override
    public User findUserById(int id) {
        return new User(1,"郭家旗","太原理工大学");
    }
}
