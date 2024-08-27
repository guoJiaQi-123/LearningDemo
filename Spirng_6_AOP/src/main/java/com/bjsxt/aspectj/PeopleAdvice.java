package com.bjsxt.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

public class PeopleAdvice {


    /**
         需要切入点方法参数的前置通知：
         参数是否有顺序问题？
              通知的参数顺序不是必须和切入点方法参数顺序完全相同，可以自己来进行定义。
              但是必须和配置文件中args-name属性配置的顺序相同。
         参数个数是否必须相同？
              是的
         参数名称是否必须相同？
              不需要和切入点参数名称对应。
              但是必须和argS-name名称对应，及args()里面名称对应。
     */
    //前置通知 可以接收切入点参数
    public void before(String name,int age){
        System.out.println("before:age:"+age+"name:"+name);
    }

    //后置通知，可以接收切入点参数和返回值
    public void afterReturning(String name,int age,String returnValue){
        System.out.println("after-return:age:"+age+"name:"+name+" returnValue:"+returnValue);
    }

    //最终通知，可以接收切入点参数，但是不能接收返回值
    public void after(String name,int age){
        System.out.println("after");
    }

    //环绕通知，可以接收切入点参数 result就是切入点返回值
    public Object around(ProceedingJoinPoint pjp,String name,int age) throws Throwable {
        System.out.println("环绕通知前：name:"+name+" age:"+age);
        Object result = pjp.proceed();
        System.out.println("环绕通知后：name:"+name+" age:"+age);
        return result;
    }

    //异常通知，（切入点方法执行发生异常时才会执行该通知）可以接收切入点参数，但是不能接收返回值 必须有throwing属性
    public void afterThrowing(String name,int age,Exception e) {

        System.out.println("after-throwing" + "age:" + age + "name:" + name + " e:" + e);

    }

}
