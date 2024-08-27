package com.bjsxt.JDKProxy;

import com.bjsxt.staticProxy.Kehu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class KeHu {

    public static void main(String[] args) {



        //动态代理：动态：不是就调用某个对象的方法，而是想调哪个对象都可以
        InvocationHandler zhongJie = new ZhongJie(new FangDong());
        //生成代理对象
        /**
         * 参数1：ClassLoader   在当前程序中，所有类的类加载器都是同一个对象
         *       作用：让生成的代理对象立即生效，（invoke中的proxy对象）// 类加载器
         * 参数2：Class[]，放接口，告诉编译器，调用的是哪个方法
         *       作用：数组中放哪个接口，接口中的方法对象就会传递给invoke中的method方法对象
         *       //被代理接口
         * 参数3：InvocationHandler对象，负责调用真实对象的处理类，就是ZhongJie  也就是代理方式对象
         */
        bigHouse bigHouse = (bigHouse) Proxy.newProxyInstance(Kehu.class.getClassLoader(), new Class[]{bigHouse.class}, zhongJie);
        bigHouse.bighose();
    }
}
