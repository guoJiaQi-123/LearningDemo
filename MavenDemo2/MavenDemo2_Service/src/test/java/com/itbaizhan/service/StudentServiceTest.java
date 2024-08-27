package com.itbaizhan.service;

import com.itbaizhan.pojo.Student;
import org.junit.Test;

import java.util.List;

public class StudentServiceTest {
    @Test
    public void testFindAllStudent() throws Exception {
        StudentService service = new StudentService();
        List<Student> allStudent = service.findAllStudent();
        allStudent.forEach(System.out::println);
    }
}
