package com.tyut.pattern._01_creative_model.e01singleton.demo6;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 单例设计模式 - 懒汉式 > 静态内部类实现 <
 */
public class Singleton {
    /**
     * 静态内部类单例模式中实例由内部类创建，
     * 由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载,
     * 并初始化其静态属性。静态属性由于被 `static` 修饰，保证只被实例化一次，并且严格保证实例化顺序。
     */


    // 1.构造器私有化
    private Singleton() {}

    // 2.创建静态内部类，并且在静态内部类中创建外部类的实例
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3.对外提供可以获得本类实例的静态方法
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
