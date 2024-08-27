package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：判断线程是否存活isAlive()
 */
class Alive implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<4;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class TestAliveThread {
    public static void main(String[] args) {
        Thread t1=new Thread(new Alive());
        t1.setName("Alive");
        t1.start();
        System.out.println(t1.getName()+"  "+t1.isAlive());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t1.getName()+"  "+t1.isAlive());
    }
}
