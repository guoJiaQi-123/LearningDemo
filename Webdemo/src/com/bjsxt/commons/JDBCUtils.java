package com.bjsxt.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        try {
            //读取properties配置文件
        ResourceBundle resourceBundle=ResourceBundle.getBundle("JDBC");
        //获取数据库驱动全名
        driver = resourceBundle.getString("jdbc.driver");
        //获取连接数据库的url
        url = resourceBundle.getString("jdbc.url");
        //获取连接数据库的用户名
        username = resourceBundle.getString("jdbc.username");
        //获取连接数据库的密码
        password = resourceBundle.getString("jdbc.password");
        //通过反射实现数据库的加载与注册
        Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollBack(Connection conn){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
