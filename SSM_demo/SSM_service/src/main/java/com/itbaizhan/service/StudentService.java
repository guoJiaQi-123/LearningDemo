package com.itbaizhan.service;

import com.itbaizhan.dao.StudentDao;
import com.itbaizhan.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    //查询所有学生
    public List<Student> findAllStudent(){
        return studentDao.findAll();
    }

    //添加学生
    public void addStudent(Student student){
        studentDao.add(student);
    }

    //根据id删除学生
    public void deleteStudentById(int id){studentDao.remove(id);}
}
