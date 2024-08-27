package com.itbaizhan.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.springbootmybatisplus.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void testFindStudentById(){
        Student student = studentMapper.selectById(4);
        System.out.println(student);
    }

    @Test
    @DisplayName("测试mybatis-plus新增方法")
    void testInsert(){
        Student student = new Student(null, "guojiaqi", "guojiaqi5946@Outlook,com", "f", 19);
        studentMapper.insert(student);
        // MyBatisPlus插入成功后，可直接直接获取主键的值
        System.out.println(student.getId());
    }

    @Test
    @DisplayName("测试mybatis-plus更新方法")
    void updateById(){
        //创建实体类对象
        Student student = new Student();
        //设置需要更新的属性
        student.setName("郭家旗");
        //设置需要修改的数据id
        student.setId(2);
        //根据主键进行更新，没有设置的值则忽略
        studentMapper.updateById(student);
    }

    @Test
    @DisplayName("根据id删除")
    void deleteById(){

        studentMapper.deleteById(1);

    }


    @Test
    @DisplayName("根据id批量删除")
    void deleteBatchIds(){
        List<Integer> ids = new ArrayList<>();
        ids.add(7);
        ids.add(8);

        studentMapper.deleteBatchIds(ids);

    }


    @Test
    @DisplayName("根据其他字段删除")
    void deleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("gender","f");
        studentMapper.deleteByMap(map);
    }

    @Test
    @DisplayName("根据id查询")
    void findById(){
        Student student = studentMapper.selectById(3);
        System.out.println(student);
    }

    @Test
    @DisplayName("根据id批量查询")
    void findByBatch(){
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(5);
        ids.add(6);
        List<Student> students = studentMapper.selectBatchIds(ids);
        students.forEach(System.out::println);
    }

    @Test
    @DisplayName("根据字段查询")
    void findByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("sname","小张");
        map.put("gender","m");
        List<Student> students = studentMapper.selectByMap(map);
        students.forEach(System.out::println);
    }

    @Test
    @DisplayName("查询名字包含\"小\"的学生，按照年龄升序排序")
    void testFindWrapper1(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sname","小").orderByAsc("age");
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    @DisplayName("查询性别为男，且年龄小于等于35的数据")
    void testFindWrapper(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender","m").le("age",35);
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }
    @Test
    @DisplayName("查询年龄小于25或年龄大于30的人")
    void testFindWrapper2(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("age",25).or().gt("age",30);
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(System.out::println);
    }

    @Test
    @DisplayName("测试分页查询")
    void testPage(){
        //创建分页条件，从第0条开始，每页查询两条
        Page page = new Page(0,2);
        //执行分页查询
        Page ipage = studentMapper.selectPage(page, null);
        // 打印分页数据
        System.out.println("查询结果："+page.getRecords());
        System.out.println("总页数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页条数："+page.getSize());
    }

    @Test
    @DisplayName("测试自定义全表删除")
    void testDeleteAll(){
        studentMapper.deleteAll();
    }
}
