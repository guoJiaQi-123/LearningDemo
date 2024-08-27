package com.itbaizhan.mapper;

import com.itbaizhan.domain.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)//spring集成junit
@SpringJUnitConfig // spring集成junit jupiter
@ContextConfiguration(locations = "classpath:applicationContext.xml")//spring配置文件
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

//    @Test  junit4
    @Test //junit jupiter
    public void testFindStudentById(){
        Student student = studentMapper.selectById(2);
        System.out.println(student);
    }
}
