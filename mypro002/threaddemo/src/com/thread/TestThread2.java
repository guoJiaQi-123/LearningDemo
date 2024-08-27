package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：通过Runnable接口实现多线程

 */

public class TestThread2 implements Runnable{//自定义类实现Runnable接口；
    //run()方法里是线程体；
    @Override
    public void run() {
        for(int i =0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象，把实现了Runnable接口的对象作为参数传入；
        Thread thread1 = new Thread(new TestThread2());
        //启动线程
        thread1.start();

        Thread thread2=new Thread(new TestThread2());
        thread2.start();
    }
}
