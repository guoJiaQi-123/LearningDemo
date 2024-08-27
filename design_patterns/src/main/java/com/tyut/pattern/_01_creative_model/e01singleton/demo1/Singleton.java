package com.tyut.pattern._01_creative_model.e01singleton.demo1;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 单例设计模式 - 饿汉式：静态变量实现
 */
public class Singleton {

    // 1.构造方法私有化
    private Singleton() {}

    // 2.在成员位置创建本类的对象
    private static final Singleton instance = new Singleton();

    // 3.对外界提供可以访问到自身创建的对象的静态方法
    public static Singleton getInstance(){
        return instance;
    }
}
