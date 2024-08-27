package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/20
 *本类内容：线程死锁
 */

/**
 * 镜子类
 */
class mirror{

}

/**
 * 口红类
 */
class lipstick{

}

//化妆线程
class MakeupThread extends Thread {
    private String name;
    private int flag;
    private static lipstick lipstick = new lipstick();
    private static mirror mirror = new mirror();

    public MakeupThread(int flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    @Override
    public void run() {
        this.MakeUp();
    }

    /**
     * 化妆方法
     */
    public void MakeUp() {
        if (flag == 0) {//flag==0 : 口红      flag！=1 : 镜子
            synchronized (lipstick) {
                System.out.println(this.name + "拿到了口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            synchronized (mirror) {
                System.out.println(this.name + "拿到了镜子");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.name + "拿到了镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            synchronized (lipstick) {
                System.out.println(this.name + "拿到了口红");
            }
        }
    }
}


public class DeadLockThread {
    public static void main(String[] args) {
        new MakeupThread(0,"苏红润").start();
        new MakeupThread(1,"韩瑜").start();
    }
}
