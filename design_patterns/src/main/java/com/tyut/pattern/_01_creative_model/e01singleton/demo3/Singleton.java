package com.tyut.pattern._01_creative_model.e01singleton.demo3;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 单例设计模式 - 懒汉式 > 线程不安全 <
 */
public class Singleton {

    // 1.构造器私有化
    private Singleton() {
    }

    // 2.在成员位置创建本类的对象
    private static Singleton instance;

    // 3.对外提供可以获取到本类对象的静态方法
    public static Singleton getInstance() {
        // 只有在instance变量还没有实例化对象的时候，才实例化一个对象
        if (instance == null) {
            // 线程1 -> 等待
            // 线程2，分配到CPU，实例化了一个Singleton实例并赋值给instance变量
            // 线程1，因为已经进入判断，因此线程1又实例化了一个Singleton对象，不符合单例模式
            instance = new Singleton();
        }
        return instance;
    }
}
