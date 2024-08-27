package com.bjsxt.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

@Component
public class MyThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception e){
        System.out.println("触发异常通知");
    }
}
