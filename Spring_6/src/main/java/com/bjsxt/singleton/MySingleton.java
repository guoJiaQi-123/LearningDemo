package com.bjsxt.singleton;


/**
 * 单例设计模式
 *  饿汉式
 */
public class MySingleton {
    //所谓饿汉式，就是在类加载时就创建好实例对象
    private static MySingleton mySingleton = new MySingleton();

    //只要是单例设计模式，必须将构造方法私有化
    private MySingleton(){}


    //必须提供一个对外的方法获取当前类实例
    //static 静态方法，可以不用实例化当前类对象即可调用该方法获取实例
    public static MySingleton newInstance(){
        return mySingleton;
    }
}
