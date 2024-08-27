package com.itbaizhan.jdkdynamic;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        // 被代理对象
        Apple apple=new AppleImpl();
        // 代理方式对象
        ShoppingProxy shoppingProxy = new ShoppingProxy(apple);

        //生成代理对象
        Apple appleJD = (Apple) Proxy.newProxyInstance(apple.getClass().getClassLoader(), //被代理对象类加载器
                apple.getClass().getInterfaces(), //被代理接口
                shoppingProxy //代理方式对象
        );
        //执行增强后的方法
        String sell = appleJD.sell(9000);
        System.out.println(sell);

        appleJD.repair();
    }
}
