/*
package com.itbaizhan.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//通知类
@Component
@Aspect
public class MyAspectJAdvice2 {

    //配置切点
    @Pointcut("execution(* com.itbaizhan.dao.UserDao.* (..))")
    public void pointcut(){}


    //后置通知
    @AfterReturning("pointcut()")
    public void myAfterReturning(JoinPoint joinpoint){
        System.out.println("切点方法名："+joinpoint.getSignature().getName());
        System.out.println("目标对象："+joinpoint.getTarget());
        System.out.println("打印日志："+joinpoint.getSignature().getName()+"方法被执行了");
    }

    //前置通知
    @Before("pointcut()")
    public void myBefore(){
        System.out.println("前置通知...");
    }
    //异常通知
    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void myAfterThrowing(Exception exception){
        System.out.println("异常通知");
        System.err.println(exception.getMessage());
    }

    //最终通知
    @After("pointcut()")
    public void myAfter(){
        System.out.println("最终通知");
    }

    //环绕通知
    @Around("pointcut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后");
        return proceed;
    }
}
*/
