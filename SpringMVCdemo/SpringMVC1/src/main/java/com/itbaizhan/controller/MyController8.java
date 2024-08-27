package com.itbaizhan.controller;

import com.itbaizhan.domain.Result;
import com.itbaizhan.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/c8")
public class MyController8 {

    @GetMapping("/addStudent")
    public @ResponseBody Result addStudent(String name, String sex){
        // 输出接受到的参数，模拟添加学生
        System.out.println(name+":"+sex);
        // 返回添加结果
        return new Result(true,"添加学生");
    }

    @PostMapping("/addStudent2")
    public @ResponseBody Result addStudent2(@RequestBody Student student){
        // 输出接受到的参数，模拟添加学生
        System.out.println(student);
        // 返回添加结果
        return new Result(true,"添加学生");
    }

}
