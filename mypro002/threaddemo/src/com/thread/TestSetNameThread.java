package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：设置线程的名称
 */
class SetName1 extends Thread{
    //通过继承Thread实现的线程可以通过子类的构造方法调用父类的构造方法修改线程名称
    public SetName1(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName());
    }
}
class SetName2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class TestSetNameThread {
    public static void main(String[] args) {
        SetName1 setName1=new SetName1("SetName1");
        setName1.start();

        Thread t1 =new Thread(new SetName2());
        //用Runnable接口实现的线程在线程启动前已经包装为Thread对象，可以直接调用setName方法设置线程名称
        t1.setName("SetName2");
        t1.start();
    }
}
