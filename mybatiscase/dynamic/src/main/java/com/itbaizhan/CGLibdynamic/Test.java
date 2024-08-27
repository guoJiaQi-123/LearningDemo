package com.itbaizhan.CGLibdynamic;

import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        //被代理对象
        Apple apple = new Apple();
        //代理方式对象
        ShoppingProxy shoppingProxy =new ShoppingProxy(apple);

        //生成代理对象
        Apple appleTB = (Apple)Enhancer.create(Apple.class, shoppingProxy);
        //执行增强后的方法
        String sell = appleTB.sell(9000);

        System.out.println(sell);
    }


}
