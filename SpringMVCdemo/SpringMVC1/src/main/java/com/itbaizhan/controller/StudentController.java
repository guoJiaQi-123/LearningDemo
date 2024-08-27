package com.itbaizhan.controller;

import com.itbaizhan.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    // 路径中的{id}表示占位符，最后会封装到方法的参数中使用
    //新增学生，RESTful风格使用POST请求
//    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    @PostMapping("/{id}")
    public String insertStudent(@PathVariable(value = "id") int id, Student student){
        System.out.println("新增学生");
        System.out.println(student);
        return "helloGJQ";
    }
    //修改学生，RESTful风格使用PUT请求
//    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    // 如果占位符和参数名相同，可以省略@PathVariable的value属性
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable(value = "id") int id,Student student){
        System.out.println("更新学生");
        System.out.println(student);
        return "helloGJQ";
    }
    //删除学生，RESTful风格使用DELETE请求
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(value = "id") int id){
        System.out.println("删除ID为"+id+"的学生");
        return "helloGJQ";
    }
    //查找学生，RESTful风格使用GET请求
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String findStudentById(@PathVariable(value = "id") int id){
        System.out.println("根据id查询学生");
        return "helloGJQ";
    }
}
