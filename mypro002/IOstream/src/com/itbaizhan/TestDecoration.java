package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/16
 *本类内容：装饰器模式
 */
class iPhone{
    private String iPhoneName;
    public iPhone(String iPhoneName){
        this.iPhoneName=iPhoneName;
    }
    public void show(){
        System.out.println("您是："+iPhoneName+",您现在可以在屏幕上显示！！");
    }
}

class touyingIphone{
    private iPhone iPhone;
    public touyingIphone(iPhone iPhone){
        this.iPhone=iPhone;
    }
    public void show(){ // 功能更强的方法
        iPhone.show();
        System.out.println("现在可以在墙上投影使用手机");
    }
}


public class TestDecoration {
    public static void main(String[] args) {
        iPhone iPhone=new iPhone("苹果8");
        iPhone.show();
        System.out.println("*******装上可以投影的手机壳********");
        touyingIphone touyingIphone=new touyingIphone(iPhone);
        touyingIphone.show();
    }
}
