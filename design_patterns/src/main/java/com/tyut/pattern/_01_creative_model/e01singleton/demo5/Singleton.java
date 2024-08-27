package com.tyut.pattern._01_creative_model.e01singleton.demo5;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 单例设计模式 - 懒汉式 <b> > 双重检查锁模式 < <b/><br/>
 *          <p>多线程环境下，不会出现线程安全问题，也不会有性能问题*推荐使用*<p/>
 */
public class Singleton {

    // 1.构造器私有化
    private Singleton(){}

    // 2.在成员位置声明Singleton类型的静态变量并用volatile关键字修饰
    private static volatile Singleton instance;

    // 3.对外提供可以获取本类对象的静态方法，并在方法内采用双重检查锁保证线程安全
    public static Singleton getInstance(){
        // 第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if(instance==null){
            synchronized (Singleton.class){
                // 抢到锁之后再次判断是否为null
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
