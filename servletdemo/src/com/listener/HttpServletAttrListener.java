package com.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class HttpServletAttrListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("---HttpServletAttrListener------start add----------------");
        System.out.println("Name: "+srae.getName()+" value: "+srae.getValue());
        System.out.println(srae.getServletRequest());
        System.out.println("---HttpServletAttrListener------end add----------------");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("---HttpServletAttrListener------start Removed----------------");
        System.out.println("Name: "+srae.getName()+" value: "+srae.getValue());
        System.out.println(srae.getServletRequest());
        System.out.println("---HttpServletAttrListener------end Removed----------------");    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("---HttpServletAttrListener------start Replaced----------------");
        System.out.println("Name: "+srae.getName()+" value: "+srae.getValue());
        System.out.println(srae.getServletRequest());
        System.out.println("---HttpServletAttrListener------end Replaced----------------");
    }
}
