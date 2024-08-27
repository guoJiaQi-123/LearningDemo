package com.bjsxt.service.impl;

import com.bjsxt.service.ServiceDemo;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class ServiceDemoImpl implements ServiceDemo {

    @Override
    public void a() {
        System.out.println("a");
    }

    @Override
    public void b() {
        System.out.println("b");
//        int i=1/0;
        //System.out.println("b2");

    }

    @Override
    public void c() {
        System.out.println("c");

    }
}
