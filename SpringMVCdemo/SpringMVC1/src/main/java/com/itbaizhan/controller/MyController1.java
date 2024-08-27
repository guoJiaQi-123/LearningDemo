package com.itbaizhan.controller;


import com.itbaizhan.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class MyController1 {

    // 该方法的访问路径是/hello
    @RequestMapping("/hello")
    public void myController(){
        System.out.println("hello MVC");
    }


    //封装简单数据类型参数到控制器
    @RequestMapping("/c1/param1")
    public void simpleParam(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    //将请求参数直接封装为对象
    @RequestMapping("/c1/param2")
    public void objParam(Student student){
        System.out.println(student);
    }

    //封装关联对象类型参数
    @RequestMapping("/c1/param3")
    public void objParam2(Student student){
        System.out.println(student);
    }

    //封装为简单数据类型的集合，在参数前需要加@RequestParam注解
    @RequestMapping("/c1/param4")
    public void listParam(@RequestParam List<String> users){
        System.out.println(users);
    }

    //封装为简单数据类型的数组，在参数前需要加@RequestParam注解
    @RequestMapping("/c1/param5")
    public void arrParam(@RequestParam String[] users){
        System.out.println(users[0]);
        System.out.println(users[1]);
    }

    //封装为对象类型集合
    @RequestMapping("/c1/param6")
    public void listParam2(Student student){
        System.out.println(student);
    }

    //封装为对象类型为Map
    @RequestMapping("/c1/param7")
    public void mapParam(Student student){
        System.out.println(student);
    }

    @RequestMapping("/c1/param8")
    public void converterParam(Date date){
        System.out.println(date);
    }

}
