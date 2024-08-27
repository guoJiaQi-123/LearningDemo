package com.tyut.pattern._01_creative_model.e01singleton.demo8;

import java.io.Serializable;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 破坏单例模式 - 序列化/反序列化
 */
public class Singleton implements Serializable {

    // 1.构造器私有化
    private Singleton() {
    }

    // 2.创建静态内部类，并且在静态内部类中创建外部类的实例
    private static class SingletonHandel {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 3.对外提供可以获取到本类对象的静态方法
    public static Singleton getInstance() {
        return SingletonHandel.INSTANCE;
    }

    // 4.定义readResolve方法，解决由于序列化/反序列化造成的破坏单例模式

    /*
     * 如果定义了readResolve方法，在对象进行反序列化时，就会调用该方法返回对象
     * 如果没有定义，才会new新的对象
     * @return
     */
    public Object readResolve() {
        return SingletonHandel.INSTANCE;
    }

}
