package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：通过继承Thread类实现多线程
 */

public class TestThread extends Thread{//自定义类继承Thread类
    @Override
    public void run() { //run()方法里是线程体
        for(int i =0;i<10;i++){
            System.out.println(this.getName()+" : "+i);//getName()方法是返回线程名称
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        TestThread Thread1 =new TestThread();
        //启动线程
        Thread1.start();

        TestThread Thread2 =new TestThread();
        Thread2.start();
    }
}
