package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：线程优先级的使用
 */
class Priority implements Runnable{
    Boolean live = true;
    int num =0;

    @Override
    public void run() {
        while (live){
            System.out.println(Thread.currentThread().getName()+"   "+num++);
        }
    }
    public void stop(){
        live = false;
    }
}

public class TestPriorityThread {
    public static void main(String[] args) {
        Priority p1=new Priority();
        Priority p2 =new Priority();
        Thread t1 =new Thread(p1,"线程1");
        Thread t2 =new Thread(p2,"线程2");
        System.out.println(t1.getPriority());//默认线程优先级为5
        //在启动线程之前设置线程优先级
        //Thread.MAX_PRIORITY=10
        t1.setPriority(Thread.MAX_PRIORITY);
        //Thread.MIN_PRIORITY=5
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        p1.stop();
        p2.stop();
    }
}
