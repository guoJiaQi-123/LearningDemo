package com.thread;/*
 *作者：郭家旗 *时间：2023/09/18
 *本类内容：线程联合 */
class A implements Runnable{
    private Thread B;
    public A(Thread B){//构造方法
        this.B=B;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            if(i==5){
                try {
                    B.join();//线程联合
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName()+" A "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<20;i++){
            System.out.println(Thread.currentThread().getName()+"  B "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class TestJoinThread {
    public static void main(String[] args) {
        Thread t2 =new Thread(new B());
        Thread t1=new Thread(new A(t2));
        t2.start();//启动线程
        t1.start();//启动线程
        for(int i =0;i<10;i++){
            if(i==2){
                try {
                    t1.join();//线程联合
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
