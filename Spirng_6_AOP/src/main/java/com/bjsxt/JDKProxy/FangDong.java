package com.bjsxt.JDKProxy;

/**
 * JDK动态代理强制要求：真实的被调用的类必须实现接口
 */
public class FangDong implements bigHouse{
    @Override
    public void bighose() {
        System.out.println("大房子");
    }
}
