package com.bjsxt.aspectj;

public class AspectjAdvice {

    /**
     *前置通知
     */
    public void before(){
        System.out.println("Aspectj-before");
    }

    /**
     * 后置通知
     * 方法中出现异常，不执行
     */
    public void afterReturning(){
        System.out.println("after-returning");
    }

    /**
     * 最终通知
     * 方法中即使出现异常，任然执行
     */
    public void after(){
        System.out.println("after");
    }

}
