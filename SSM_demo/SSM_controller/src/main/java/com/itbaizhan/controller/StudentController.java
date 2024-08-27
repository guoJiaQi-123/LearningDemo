package com.itbaizhan.controller;

import com.itbaizhan.domain.Student;
import com.itbaizhan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/all")
    public String find(Model model){
        List<Student> allStudent = studentService.findAllStudent();
        model.addAttribute("Students",allStudent);
        return "allStudent";
    }

    @RequestMapping("/add")
    public String add(Student student){
        studentService.addStudent(student);
        // 重定向到查询所有学生
        return "redirect:/student/all";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        studentService.deleteStudentById(id);
        //重定向到查询所有学生
        return "redirect:/student/all";
    }
}
