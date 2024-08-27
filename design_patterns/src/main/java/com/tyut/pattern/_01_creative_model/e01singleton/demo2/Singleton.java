package com.tyut.pattern._01_creative_model.e01singleton.demo2;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 单例设计模式 - 饿汉式：静态代码块实现
 */
public class Singleton {

    // 1.构造器私有化
    private Singleton(){}

    // 2.声明静态全局变量
    private static Singleton instance;

    // 3.在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    // 4.对外提供可以获取本类对象的静态方法
    public static Singleton getInstance(){
        return instance;
    }
}
