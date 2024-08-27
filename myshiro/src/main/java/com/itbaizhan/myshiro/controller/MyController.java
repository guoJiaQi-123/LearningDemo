package com.itbaizhan.myshiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/reportform/find")
    public String reportFormFind(){
        return "查询报表";
    }

    @RequestMapping("/salary/find")
    public String salaryFind(){
        return "查询工资";
    }

    @RequestMapping("/stuff/find")
    public String stuffFind(){
        return "查询员工";
    }
}
