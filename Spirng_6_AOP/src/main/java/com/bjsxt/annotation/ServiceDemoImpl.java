package com.bjsxt.annotation;

import org.springframework.stereotype.Service;

@Service
public class ServiceDemoImpl {

    public void demo(){
        System.out.println("demo");
//        int i= 5/0;
    }
}
