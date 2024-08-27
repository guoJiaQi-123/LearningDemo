package com.bjsxt.annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect  //通知类必须有这个注解
@Component //必须将通知类放入IOC容器中
public class DemoAdvice {


    //一般情况下，一个通知类，都是对一个切点添加的通知
    //定义一个空方法，不需要写方法体，然后在方法上添加Pointcut注解
    //在当前通知类中，其他的通知方法可以直接通过方法名引用切点
    //注意：引用时只有方法名，没有execution()
    @Pointcut("execution(* com.bjsxt.annotation.ServiceDemoImpl.demo())")
    public void pointcut(){}

    //前置通知注解
    @Before(value = "pointcut()")
    public void before(){
        System.out.println("前置通知：before");
    }

    //后置通知
    @AfterReturning(value = "pointcut()")
    public void afterReturning(){
        System.out.println("后置通知：afterReturning");
    }


    //最终通知
    @After(value = "pointcut()")
    public void after(){
        System.out.println("最终通知：after");
    }


    //环绕通知
    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前通知：around");
        Object result = pjp.proceed();
        System.out.println("环绕后通知：around");
        return result;
    }


    //异常通知
    @AfterThrowing(value = "pointcut()")
    public void afterThrowing(){
        System.out.println("异常通知：afterThrowing");
    }
}