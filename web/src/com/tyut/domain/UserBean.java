package com.tyut.domain;

import com.tyut.common.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @version v1.0
 * @author OldGj 2024/6/18
 * @apiNote TODO(一句话给出该类描述)
 */
public class UserBean {

    private Integer id;
    private String user;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean insertUser(UserBean user) throws ClassNotFoundException, SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into user (id,name,password) values(default,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUser());
        preparedStatement.setString(2, user.getPassword());
        int i = preparedStatement.executeUpdate();
        return i > 0;
    }
}
