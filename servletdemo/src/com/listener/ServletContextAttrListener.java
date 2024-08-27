package com.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttrListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("-------------start Add------------------");
        System.out.println("Name: "+scae.getName()+"  value: "+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("-------------end Add------------------");

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("-------------start Removed------------------");
        System.out.println("Name: "+scae.getName()+"  value: "+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("-------------end Removed------------------");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("-------------start Replaced------------------");
        System.out.println("Name: "+scae.getName()+"  value: "+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("-------------end Replaced------------------");
    }
}
