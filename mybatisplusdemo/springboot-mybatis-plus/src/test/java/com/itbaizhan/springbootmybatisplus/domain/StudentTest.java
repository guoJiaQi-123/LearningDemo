package com.itbaizhan.springbootmybatisplus.domain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentTest {

    @Test
    @DisplayName("AR模式新增方法")
    void testAdd() {
        Student student = new Student(10, "guojiaqi", "guojiaqi5946@Outlook.com", "m", 20);
        student.insert();
    }

    @Test
    @DisplayName("AR模式修改方法")
    void testUpdate() {
        Student student = new Student();
        student.setName("郭家旗");
        student.setId(10);
        student.updateById();
    }

    @Test
    @DisplayName("AR模式查询方法")
    void testSelect() {
        Student student = new Student();
        student.setId(10);
        Student student1 = student.selectById();
        System.out.println(student1);
    }

    @Test
    @DisplayName("AR模式删除方法")
    void testDelete() {
        Student student = new Student();
        student.setId(9);
        student.deleteById();
    }

    @Test
    @DisplayName("查询所有")
    void testFindAll() {
        Student student = new Student();
        List<Student> students = student.selectAll();
        students.forEach(System.out::println);
    }

    @Test
    @DisplayName("分页查询")
    void testFindPage(){
        //创建分页查询条件
        Page<Student> page = new Page<>(0, 2);
        //创建条件构造器
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sname","小").orderByAsc("age");
        Student student = new Student();
        //调用分页查询方法
        Page<Student> iPage = student.selectPage(page, queryWrapper);
        System.out.println("结果集："+iPage.getRecords());
        System.out.println("总页数："+iPage.getPages());
        System.out.println("总条数："+iPage.getTotal());
        System.out.println("当前页："+iPage.getCurrent());
        System.out.println("每页条数："+iPage.getSize());
    }

    @Test
    @DisplayName("AR模式全表删除")//因为配置了防止全表删除插件，所有报错不能执行该方法
    void deleteAll(){
        Student student = new Student();
        student.delete(null);
    }

    @Test
    @DisplayName("测试乐观锁")
    void testUpdateOptimisticLocker(){
        Student student = new Student();
        student.setName("郭家旗");
        student.setVersion(0);
        student.setId(9);
        student.updateById();
    }

    @Test
    @DisplayName("测试自动填充")
    void testInsert(){
        Student student = new Student();
        student.insert();
    }
}
