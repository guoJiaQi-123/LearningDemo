package com.bjsxt;

import org.junit.jupiter.api.Test;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest {
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    @Test
    void test(){
        stringThreadLocal.set("郭家旗");

        new Thread(){
            @Override
            public void run() {
                System.out.println("子线程："+stringThreadLocal.get());
            }
        }.start();
        System.out.println("主线程："+stringThreadLocal.get());
    }

    @Test
    void test2(){


        NamedThreadLocal<Map<String,Object>> tl = new NamedThreadLocal("MyThreadLocal"){
            @Override
            protected Map<String,Object> initialValue() {
                return new HashMap<>();
            }
        };
        tl.get().put("郭家旗","牛逼");
        new Thread(){
            @Override
            public void run() {
                System.out.println("子线程："+tl.get());
            }
        }.start();
        System.out.println(tl.get().size());
    }
}
