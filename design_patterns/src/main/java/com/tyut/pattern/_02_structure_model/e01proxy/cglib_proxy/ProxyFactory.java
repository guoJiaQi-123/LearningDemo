package com.tyut.pattern._02_structure_model.e01proxy.cglib_proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 生成代理对象
 */
public class ProxyFactory implements MethodInterceptor {


    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /**
     * intercept方法参数说明：
     *
     * @param o           代理对象
     * @param method      真实对象中的方法的Method实例
     * @param objects     实际参数
     * @param methodProxy 代理对象中的方法的method实例
     * @return 真实对象中的方法的Method返回值
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理");
        // Object object = method.invoke(new TrainStation(), objects);
        return methodProxy.invokeSuper(o, objects);
    }
}
