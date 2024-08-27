package com.bjsxt.JDKProxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 在JDK动态代理底层是基于JAVA的反射机制实现的。本质上就是方法的调用
 *
 * 负责调用真实对象方法的类，必须实现InvocationHandler接口
 */
public class ZhongJie implements InvocationHandler {

    private FangDong fangDong;

    public ZhongJie(FangDong fangDong) {
        this.fangDong = fangDong;
    }

    /**
     *
     * @param proxy 产生的代理对象
     * @param method 真实对象中被调用的方法对象
     * @param args 被调用方法的参数
     * @return 被调用方法的返回值，都当做invoke方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("带看");

        //坑：千万不要用invoke方法的第一个参数proxy，他是代理对象，而不是真实对象
        Object result = method.invoke(fangDong, args);

        System.out.println("中介费");

        return result;
    }
}
