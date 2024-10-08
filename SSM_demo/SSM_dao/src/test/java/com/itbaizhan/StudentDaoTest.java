package com.itbaizhan;

import com.itbaizhan.dao.StudentDao;
import com.itbaizhan.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class StudentDaoTest {


    @Autowired
    private StudentDao studentDao;

    @Test
    public void testFindAll() {
        List<Student> all = studentDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testAdd(){
        Student student = new Student(3,"郭家旗","男","北京");
        studentDao.add(student);
    }

    @Test
    public void testRemove(){
        studentDao.remove(1);
    }


}
