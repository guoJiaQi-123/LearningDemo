package com.tyut.common;

import java.sql.*;

/**
 * @version v1.0
 * @author OldGj 2024/6/18
 * @apiNote TODO(一句话给出该类描述)
 */
public class JDBCUtils {

    private static String url;
    private static String name;
    private static String pwd;

    {
        try {
            url = "jdbc:mysql://localhost:3306/jdbc";
            name = "root";
            pwd = "root";
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeResource(Connection connection, Statement statement) {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
