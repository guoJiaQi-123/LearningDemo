package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext生命周期监听器
 */
public class ServletContextLifecycleListener implements ServletContextListener {
    /**
     * ServletContext对象创建之后会触发该监听方法，并将ServletContext对象传递到该方法中。
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init...............");
    }

    /**
     * ServletContext对象在销毁之前会触发该监听方法，并将ServletContext对象传递到该方法中。
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destroy...............");
    }
}
