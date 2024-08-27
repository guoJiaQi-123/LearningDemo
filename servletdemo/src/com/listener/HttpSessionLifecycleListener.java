package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession对象的生命周期监听器
 */
public class HttpSessionLifecycleListener implements HttpSessionListener {
    /**
     * HttpSession对象创建后会触发该监听方法，并将已创建HttpSession对象传递到该方法中。
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated");
        System.out.println(se.getSession());
    }

    /**
     * HttpSession对象在销毁之前会触发该监听方法，并将要销毁的HttpSession对象传递到该方法中。
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed");
        System.out.println(se.getSession());
    }
}
