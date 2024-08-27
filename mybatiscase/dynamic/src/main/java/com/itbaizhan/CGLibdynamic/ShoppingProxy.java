package com.itbaizhan.CGLibdynamic;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//代理方式类
//实现MethodInterceptor接口   重写intercept方法
public class ShoppingProxy implements MethodInterceptor {
    //被代理对象
    private Apple apple;

    public ShoppingProxy(Apple apple) {
        this.apple = apple;
    }

    /**
     * 原方法的增强方式
     * @param o 被代理对象
     * @param method 被代理对象调用的方法
     * @param objects 被代理对象调用的方法时，传入的参数
     * @param methodProxy 底层生成的代理类的引用
     * @return 方法的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String name = method.getName();
        if("sell".equals(name)){
            Double price = (Double) objects[0] * 0.7;
            Object result = method.invoke(apple, price);
            return result+"和数据线";
        }else if("repair".equals(name)){
            System.out.println("专属客服服务");
            return method.invoke(apple,objects);
        }else {
            return method.invoke(apple,objects);
        }
    }
}
