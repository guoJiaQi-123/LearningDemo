package com.itbaizhan.jdkdynamic;


//被代理接口的实现类
public class AppleImpl implements Apple{

    @Override
    public String sell(double price) {
        System.out.println("产品卖了"+price+"元");
        return "Iphone13";
    }

    @Override
    public void repair() {
        System.out.println("手机维修");
    }
}
