package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：守护线程
 */
class Daemon implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class TestSetDaemon {
    public static void main(String[] args) {
        Thread t1=new Thread(new Daemon(),"Daemon");
        t1.setDaemon(true);
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程结束");
    }
}
