package com.itbaizhan.service;


import com.itbaizhan.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// JUnit使用Spring方式运行代码，即自动创建spring容器。
@RunWith(SpringJUnit4ClassRunner.class)
// 告知创建spring容器时读取哪个配置类或配置文件
// 配置类写法：@ContextConfiguration(classes=配置类.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testFindAllStudent(){
        List<Student> allStudent = studentService.findAllStudent();
        allStudent.forEach(System.out::println);
    }

    @Test
    public void testAddStudent(){
        Student student = new Student("郭家旗","男","上海");
        studentService.addStudent(student);
    }
}
