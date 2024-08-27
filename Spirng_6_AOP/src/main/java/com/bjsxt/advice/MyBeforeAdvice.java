package com.bjsxt.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyBeforeAdvice implements MethodBeforeAdvice {

    /**
     *  前置通知
     * @param method 切入点方法
     * @param args 切入点方法参数
     * @param target 切入点所在对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method);
        if(args!=null){
            System.out.println(Arrays.toString(args));
        }
        System.out.println(target);

    }
}
