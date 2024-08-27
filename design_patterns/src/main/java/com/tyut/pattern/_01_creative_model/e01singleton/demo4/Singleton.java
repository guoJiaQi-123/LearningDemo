package com.tyut.pattern._01_creative_model.e01singleton.demo4;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 单例设计模式 - 懒汉式  > 线程安全 <
 */
public class Singleton {

    // 1.构造器私有化
    private Singleton (){}

    // 2.在成员位置声明Singleton类型的静态变量
    private static Singleton instance;

    // 3.对外提供一个可以获取本类对象的静态方法
    // 并且将该方法使用synchronized同步锁加锁，确保实例化过程中的线程安全
    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
