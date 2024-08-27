package com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest对象的生命周期监听器
 */
public class HttpServletRequestLifecycleListener implements ServletRequestListener {
    /**
     * HttpServletRequest对象创建后会触发该监听方法，并将已创建HttpServletRequest对象传递到该方法中。
     * @param sre
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("-----------start---Destroyed---------------");
        System.out.println((HttpServletRequest)sre.getServletRequest());
        System.out.println("-----------end---Destroyed---------------");

    }

    /**
     * HttpServletRequest对象在销毁之前会触发该监听方法，并将要销毁HttpServletRequest对象传递到该方法中。
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("-----------start---Initialized---------------");
        System.out.println((HttpServletRequest)sre.getServletRequest());
        System.out.println("-----------end---Initialized---------------");
    }
}
