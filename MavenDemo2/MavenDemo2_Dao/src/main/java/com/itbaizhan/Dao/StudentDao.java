package com.itbaizhan.Dao;

import com.itbaizhan.pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentDao {
    //查询所有学生
    public List<Student> findAll() throws Exception {
        //操作数据库
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        properties.load(is);
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.name");
        String password = properties.getProperty("jdbc.password");
        //执行查询
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");


        //处理结果集
        List<Student> students = new ArrayList();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            String address = resultSet.getString("address");
            Student student = new Student(id, name, sex, address);
            students.add(student);
        }
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();

        return students;
    }
}
