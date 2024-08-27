package com.itbaizhan.CGLibdynamic;


//被代理类
public class Apple {



    public String sell(double price) {
        System.out.println("产品卖了"+price+"元");
        return "Iphone13";
    }


    public void repair() {
        System.out.println("手机维修");
    }
}
