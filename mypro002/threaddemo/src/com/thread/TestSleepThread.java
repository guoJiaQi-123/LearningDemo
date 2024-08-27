package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：线程休眠

 */

public class TestSleepThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 子线程开始");
        for (int i =0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(1000);//线程休眠  静态方法sleep
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+"子线程结束");
    }

    public static void main(String[] args) {
        System.out.println("主线程开始");
        Thread t =new Thread(new TestSleepThread());
        t.start();
        System.out.println("主线程结束");
    }
}
