package com.bjsxt.advice;

import org.springframework.aop.AfterReturningAdvice;


import java.lang.reflect.Method;


public class MyAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知");
    }
}
