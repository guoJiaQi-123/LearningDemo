package com.itbaizhan.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @param ex 异常对象
     * @param model 模型对象
     * @return
     */
    // 添加@ExceptionHandler，表示该方法是处理异常的方法，属性为处理的异常类
    @ExceptionHandler(java.lang.NullPointerException.class)
    public String exceptionHandle1(Exception ex, Model model){
        // 向模型中添加异常对象
        model.addAttribute("message",ex);
        // 跳转到异常页面
        return "error";
    }


    //异常处理1处理不了的
    @ExceptionHandler(java.lang.Exception.class)
    public String exceptionHandle2(Exception ex, Model model){
        // 向模型中添加异常对象
        model.addAttribute("message",ex);
        // 跳转到异常页面
        return "error2";
    }
}
