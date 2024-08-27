package com.tyut.pattern._01_creative_model.e01singleton.demo9;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 破坏单例模式 - 反射
 */
public class Singleton {

    // 是否多次调用构造器
    private static boolean flag = false;

    //1.构造器私有化
    private Singleton() {
        /*
            解决通过反射破坏单例模式
         */
        synchronized (Singleton.class) {
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            //在第一次调用构造器之后，flag设为true，下次调用则抛出异常
            flag = true;
        }
    }

    //2.在成员位置声明本类的静态变量
    private static volatile Singleton instance;

    //3.对外提供可获得本类实例的静态方法
    public static Singleton getInstance() {

        /*
         * 双重检查锁
         */
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
