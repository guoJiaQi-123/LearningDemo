package com.itbaizhan.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 自定义异常处理器实现HandlerExceptionResolver接口，并放入Spring容器中
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof NullPointerException){
            modelAndView.setViewName("error2");
        }else {
            modelAndView.setViewName("error");
        }
        modelAndView.addObject("message",e);
        return modelAndView;
    }
}
