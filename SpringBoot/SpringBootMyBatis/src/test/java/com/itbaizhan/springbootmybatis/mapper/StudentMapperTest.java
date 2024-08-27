package com.itbaizhan.springbootmybatis.mapper;

import com.itbaizhan.springbootmybatis.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// 测试类注解，可以在运行测试代码时加载Spring容器
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testFindAll(){
        List<Student> all = studentMapper.findAll();
        all.forEach(System.out::println);
    }
}