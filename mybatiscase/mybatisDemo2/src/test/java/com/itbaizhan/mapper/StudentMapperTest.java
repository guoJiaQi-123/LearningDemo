package com.itbaizhan.mapper;

import com.itbaizhan.mapper2.ClassesMapper2;
import com.itbaizhan.mapper2.StudentMapper2;
import com.itbaizhan.pojo.Classes;
import com.itbaizhan.pojo.Student;
import com.itbaizhan.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentMapperTest {
    InputStream resourceAsStream = null;
    SqlSession sqlSession = null;
    private Student allStudent;

    @Before
    public void before() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @After
    public void after() throws IOException {
        resourceAsStream.close();
        sqlSession.close();
    }

    @Test
    public void testFindAllStudent(){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = studentMapper.findAllStudent();
        allStudent.forEach(System.out::println);
    }

    @Test
    public void testFindAllClasses(){
        ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
        List<Classes> allClasses = classesMapper.findAllClasses();
        allClasses.forEach(System.out::println);
    }

    @Test
    public void testFindAllTeacher(){
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> allTeacher = teacherMapper.findAllTeacher();
        allTeacher.forEach(System.out::println);
    }

    @Test
    public void testFindAllClasses2(){
        ClassesMapper2 mapper = sqlSession.getMapper(ClassesMapper2.class);
        List<Classes> allClasses = mapper.findAllClasses();
        allClasses.forEach(System.out::println);
    }

    @Test
    public void testFindAllStudent2(){
        StudentMapper2 mapper = sqlSession.getMapper(StudentMapper2.class);
        List<Student> allStudent = mapper.findAllStudent();
        allStudent.forEach(System.out::println);


    }
}
