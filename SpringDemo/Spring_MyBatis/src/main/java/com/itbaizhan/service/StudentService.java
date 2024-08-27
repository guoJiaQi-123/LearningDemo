package com.itbaizhan.service;

import com.itbaizhan.dao.StudentDao;
import com.itbaizhan.domain.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    /*

    //SqlSession对象
    @Autowired
    private SqlSessionTemplate sqlSession;

    // 使用SqlSession获取代理对象
    public List<Student> findAllStudent(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        return studentDao.findAll();
    }
*/

    // 直接注入代理对象
    @Autowired
    private StudentDao studentDao;

    public List<Student> findAllStudent(){
         return studentDao.findAll();
    }
    // 直接使用代理对象
    public void addStudent(Student student){
        studentDao.add(student);
    }
}
