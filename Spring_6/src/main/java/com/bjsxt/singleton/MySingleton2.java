package com.bjsxt.singleton;


/**
 * 单例模式核心思想：
 *  * 1. 构造方法私有
 *  * 2. 对外提供一个能够获取对象的方法。
 *
 * 懒汉式：在获取对象时才去实例化，按需实例化
 *
 *        优点：按需创建对象。不会在加载类时直接实例化对象。
 *
 *        缺点：在多线程环境下，第一次访问的效率慢
 *             写法相对饿汉式更加复杂
 */
public class MySingleton2 {

    private static MySingleton2 mySingleton2;

    //构造方法私有化
    private MySingleton2(){}


    //对外提供可以获取实例的方法
    //不加锁在多线程环境下可能出现多个实例
    public static MySingleton2 newInstance(){
        if(mySingleton2==null) { //在以及实例化后，其他线程不做等待，之间返回实例对象
            synchronized (MySingleton2.class) {//如果不在锁外加判断，在多线程情况下，其他线程会一直处于等待
                if (mySingleton2 == null) {
                    mySingleton2 = new MySingleton2();
                }
            }
        }
        return mySingleton2;
    }

}
