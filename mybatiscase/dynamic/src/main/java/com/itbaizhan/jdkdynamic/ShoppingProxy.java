package com.itbaizhan.jdkdynamic;


import sun.management.Agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理方式类：定义被代理接口的增强方式
// 该类实现InvocationHandler接口，重写invoke方法，定义方法的增强方式
public class ShoppingProxy implements InvocationHandler {

    //被代理对象
    private Apple apple;

    public ShoppingProxy(Apple apple) {
        this.apple = apple;
    }

    /**
     *
     * @param proxy 被代理对象
     *
     * @param method 被代理对象调用的方法
     *
     * @param args 被代理对象调用的方法时，传入的参数
     *
     * @return 方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if("sell".equals(name)){
            double price = (double) args[0]*0.9; //增强参数
            Object result = method.invoke(apple, price);
            return result+"和充电头";  //增强返回值
        }else if("repair".equals(name)){
            System.out.println("专属客服服务");// 增强方法流程
            return method.invoke(apple,args);

        }else {
            return method.invoke(apple, args);// 什么都不增强
        }

    }
}
