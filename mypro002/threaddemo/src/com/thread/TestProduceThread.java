package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/20
 *本类内容：实现生产者与消费者模式   创建缓冲区
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 馒头类
 */
class manTou{
    private int id;
    public manTou(int id){
        this.id=id;
    }

    public manTou() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

/**
 * 创建缓冲区
 */
class SyncStack{
    private manTou[] box=new manTou[10];//定义存放馒头的盒子
    private int index;//定义操作盒子的索引
    /**
     * 放馒头方法
     */
    public synchronized void push(manTou manTou){
        if(index==box.length){//判断盒子是否已满
            try {/**
             * 语法：wait(),该方法必须要在synchronized块中调用。
             * wait执行后，线程会将持有的对象锁释放，并进入阻塞状态，
             * 其他需要该对象锁的线程就可以继续运行了。
             */
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //唤醒取馒头的线程
        /**
         * 语法：该方法必须要在synchronized块中调用。
         * 该方法会唤醒处于等待状态队列中的一个线程。
         */
        this.notify();
        this.box[this.index]=manTou;
        this.index++;
    }

    /**
     * 取馒头方法
     */
    public synchronized manTou pop(){
        if(index==0){
            try {/**
             * 语法：wait(),该方法必须要在synchronized块中调用。
             * wait执行后，线程会将持有的对象锁释放，并进入阻塞状态，
             * 其他需要该对象锁的线程就可以继续运行了。
             */
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //唤醒取馒头的线程
        /**
         * 语法：该方法必须要在synchronized块中调用。
         * 该方法会唤醒处于等待状态队列中的一个线程。
         */
        this.notify();
        index--;
        return this.box[this.index];
    }
}
//生产者线程
class shenchan extends Thread{
    private SyncStack ss;
    public shenchan(SyncStack ss){
        this.ss=ss;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            manTou manTou =new manTou();
            manTou.setId(i);
            System.out.println("生产馒头"+manTou.getId());
            this.ss.push(manTou);
        }
    }
}
//消费者线程
class xiaofei extends Thread{
    private SyncStack ss;
    public xiaofei (SyncStack ss){
        this.ss=ss;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            manTou manTou=this.ss.pop();
            System.out.println("消费馒头"+manTou.getId());
        }
    }
}

public class TestProduceThread {
    public static void main(String[] args) {
        SyncStack syncStack=new SyncStack();
        new xiaofei(syncStack).start();
        new shenchan(syncStack).start();

    }
}
