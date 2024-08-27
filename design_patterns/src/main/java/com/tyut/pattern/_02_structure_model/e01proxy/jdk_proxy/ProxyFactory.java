package com.tyut.pattern._02_structure_model.e01proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 代理对象工厂，用来创建代理对象
 */
public class ProxyFactory {

    // 目标代理对象
    private Object target = new TrainStation();

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public SellTicket getProxy() {
        /*
            newProxyInstance方法的三个参数：
            1.ClassLoader loader,  类加载器，用于加载代理类，使用真实对象的类加载器即可
            2.Class<?>[] interfaces,真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
            3.InvocationHandler h  代理对象的调用处理程序
         */
        //使用Proxy方法获取代理对象
        return (SellTicket) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                        InvocationHandler中invoke方法参数说明：
                            proxy ： 代理对象
                            method ： 对应于在代理对象上调用的接口方法的 Method 实例
                            args ： 代理对象调用接口方法时传递的实际参数
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("DynamicProxy: Before requesting.");
                        Object result = method.invoke(target, args);
                        System.out.println("DynamicProxy: After requesting.");
                        return result;
                    }
                }
        );
    }

}
