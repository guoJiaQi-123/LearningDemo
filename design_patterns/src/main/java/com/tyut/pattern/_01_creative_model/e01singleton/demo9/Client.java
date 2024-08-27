package com.tyut.pattern._01_creative_model.e01singleton.demo9;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 测试 反射机制是否会破坏单例模式
 */
public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 1.获取单例对象的字节码对象
        Class clazz = Singleton.class;
        // 2.获取无参构造
        Constructor constructor = clazz.getDeclaredConstructor();
        // 3.关闭访问权限
        constructor.setAccessible(true);
        // 4.创建对象
        Singleton s1 = (Singleton) constructor.newInstance();
        Singleton s2 = (Singleton) constructor.newInstance();
        // 如果返回true，说明反射不会破坏单例模式，如果返回false,说明反射会破坏单例模式
        System.out.println(s1 == s2);

    }
}
