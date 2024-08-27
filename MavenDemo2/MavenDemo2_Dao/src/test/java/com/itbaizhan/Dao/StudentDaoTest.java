package com.itbaizhan.Dao;

import com.itbaizhan.pojo.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    @Test
    public void testFindAll() throws Exception {
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.findAll();
        students.forEach(System.out::println);
    }
}
