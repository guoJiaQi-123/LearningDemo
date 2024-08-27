package com.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttrListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("---HttpSessionAttrListener------start add----------------");
        System.out.println("Name: "+se.getName()+" value: "+se.getValue());
        System.out.println(se.getSession());
        System.out.println("---HttpSessionAttrListener------end add----------------");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("---HttpSessionAttrListener------start Removed----------------");
        System.out.println("Name: "+se.getName()+" value: "+se.getValue());
        System.out.println(se.getSession());
        System.out.println("---HttpSessionAttrListener------end Removed----------------");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("---HttpSessionAttrListener------start Replaced----------------");
        System.out.println("Name: "+se.getName()+" value: "+se.getValue());
        System.out.println(se.getSession());
        System.out.println("---HttpSessionAttrListener------end Replaced----------------");
    }
}
