package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/18
 *本类内容：终止线程的典型方式
 */
import java.io.IOException;

public class TestStopThread implements Runnable{
    //定义一个生死牌
    private Boolean flag = true;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  子线程开始");
        int i=0;
        while (flag){

            System.out.println(Thread.currentThread().getName()+" "+i++);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
    public void stop(){
        flag=false;
    }

    public static void main(String[] args) {
        System.out.println("主线程开始");
        TestStopThread tst=new TestStopThread();
        Thread t = new Thread(tst);
        t.start();
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tst.stop();
        System.out.println("主线程结束");
    }
}
