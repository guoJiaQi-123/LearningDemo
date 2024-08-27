package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：线程让步
 */

public class TestYieldThread implements Runnable{
    @Override
    public void run() {
        for (int i =0;i<20;i++){
            if("Thread-0".equals(Thread.currentThread().getName())){
                if(i==0){
                    System.out.println("让步");
                    Thread.yield();
                }
            }
            System.out.println(Thread.currentThread().getName()+"  "+i );
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new TestYieldThread());
        Thread t2=new Thread(new TestYieldThread());
        t1.start();

        t2.start();
    }
}
