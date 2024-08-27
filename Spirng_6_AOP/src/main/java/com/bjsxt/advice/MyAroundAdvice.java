package com.bjsxt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕通知-前置增强");
        Object result = invocation.proceed();
        System.out.println("环绕通知-后置增强");
        return result;
    }
}
