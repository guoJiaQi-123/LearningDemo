package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：Thread类中的其他常用方法    获取当前线程名称
 */
class GetName1 extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName()+"   Thread");
    }
}

class GetName2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"   runnable");
    }
}
public class TestThreadGetName {
    public static void main(String[] args) {
        GetName1 thread=new GetName1();
        thread.start();
        Thread t1 =new Thread(new GetName2());
        t1.start();
    }
}
