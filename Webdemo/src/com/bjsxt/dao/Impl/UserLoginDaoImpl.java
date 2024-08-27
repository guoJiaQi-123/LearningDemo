package com.bjsxt.dao.Impl;

import com.bjsxt.commons.JDBCUtils;
import com.bjsxt.dao.UserLoginDao;
import com.bjsxt.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDaoImpl implements UserLoginDao {
    /**
     * 用户登录的数据库查询
     * @param username
     * @param userpwd
     * @return
     */
    @Override
    public Users selectUsersByUserNameAndUserPwd(String username, String userpwd) {
        Connection conn=null;
        Users user=null;
        try {
            conn = JDBCUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from users where username = ? and userpwd = ?");
            ps.setString(1,username);
            ps.setString(2,userpwd);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                user = new Users();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpwd(resultSet.getString("userpwd"));
                user.setUsersex(resultSet.getString("usersex"));
                user.setPhonenumber(resultSet.getString("phonenumber"));
                user.setQqnumber(resultSet.getString("qqnumber"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection(conn);
        }


        return user;
    }
}
