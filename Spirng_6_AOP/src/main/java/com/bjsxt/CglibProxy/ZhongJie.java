package com.bjsxt.CglibProxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//代理方式类，实现MethodInterceptor接口，重写intercept方法
/**
 * 作用：调用真实对象的方法
 */
public class ZhongJie implements MethodInterceptor {


    /**
     *
     * @param o 目标对象：即FangDong对象
     * @param method 目标方法
     * @param objects 目标方法参数
     * @param methodProxy 生成的代理对象（即FangDong的子类）
     * @return 目标方法返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("带看");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("中介费");
        return  result;

    }
}
