package com.itbaizhan.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class SpringAop implements AfterReturningAdvice, MethodBeforeAdvice, ThrowsAdvice, MethodInterceptor {

    /**
     * 前置通知
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知");
    }


    /**
     * 后置通知
     * @param returnValue
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("后置通知");
    }

    /**
     * 环绕通知
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前");
        Object proceed = invocation.proceed();
        System.out.println("环绕后");
        return proceed;
    }


    /**
     * 异常通知
     * @param ex 异常对象
     */
    public void afterThrowing(Exception ex){
        System.out.println("发生异常了！");
    }


}
