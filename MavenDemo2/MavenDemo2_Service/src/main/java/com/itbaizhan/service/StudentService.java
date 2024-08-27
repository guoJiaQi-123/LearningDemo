package com.itbaizhan.service;

import com.itbaizhan.Dao.StudentDao;
import com.itbaizhan.pojo.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();
    public List<Student> findAllStudent() throws Exception {
        List<Student> students = studentDao.findAll();
        return students;
    }
}
