package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：
 */
/**
 * 经理类
 */
class Manger{
    private String name;
    public Manger(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    /**
     * 敬酒方法
     */
    public void cheers(String mName,String eName){
        //synchronized (this){
            try {
                System.out.println(mName+" 走到 "+eName+"面前");
                Thread.sleep(500);
                System.out.println(eName+"站起身，拿起酒杯");
                Thread.sleep(500);
                System.out.println(mName+"和"+eName+"干杯");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        //}

    }
}
//敬酒线程
class cheersThread extends Thread{
    private Manger manger;
    private String eName;
    public cheersThread(Manger manger,String eName){
        this.eName=eName;
        this.manger=manger;
    }

    @Override
    public void run() {
        synchronized (this.manger){
            manger.cheers(manger.getName(),eName);
        }

    }
}

/**
 * 销售类
 */
class sale{
    private String name;

    public sale(String name) {
        this.name = name;
    }
    /**
     * 领取季度奖
     */
    synchronized public static void money(){
            try {
                System.out.println(Thread.currentThread().getName()+" 去销售办公室");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+"领导表扬");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+"拿钱");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+"开开心心走人");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


    }
}
//销售领取季度奖线程
class saleMoneyThread extends Thread{
    private sale sale;

    public saleMoneyThread(sale sale,String name){
        super(name);
        this.sale=sale;
    }

    @Override
    public void run() {
        sale.money();
    }
}

/**
 * 程序员类
 */
class Programmer{
    private String name;

    public Programmer(String name) {
        this.name = name;
    }
    /**
     * 打开电脑的行为
     */
    public void computer(){
        synchronized (this){
        try {
            System.out.println(this.name+" 插上电源");
            Thread.sleep(500);
            System.out.println(this.name+"按开机键");
            Thread.sleep(500);
            System.out.println(this.name+"启动系统");
            Thread.sleep(500);
            System.out.println("系统启动中");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
    /**
     * 领取季度奖行为
     */
    public void money(){
        synchronized (Programmer.class){
            try {
                System.out.println(this.name+" 去研发办公室");
                Thread.sleep(500);
                System.out.println(this.name+"领导表扬");
                Thread.sleep(500);
                System.out.println(this.name+"拿钱");
                Thread.sleep(500);
                System.out.println("开开心心走人");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    /**
     * 编码行为
     */
    public  void coding(){
        synchronized (this){
        try {
            System.out.println(this.name+"打开IDEA");
            Thread.sleep(500);
            System.out.println(this.name+"开开心心写代码，改BUG");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
    /**
     * 上厕所行为
     */
    public void wc() {
        synchronized (" ") {
            try {
                System.out.println(this.name + "打开厕所门");
                Thread.sleep(500);
                System.out.println(this.name + "开始排泄");
                Thread.sleep(500);
                System.out.println(this.name + "冲水");
                Thread.sleep(500);
                System.out.println(this.name + "离开卫生间");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//编码线程
class codingThread extends Thread{
    private Programmer programmer;
    public codingThread(Programmer programmer){
        this.programmer=programmer;
    }
    @Override
    public void run() {
        programmer.coding();
    }
}

//开电脑线程
class computerThread extends Thread{
    private Programmer programmer;

    public computerThread(Programmer programmer){
        this.programmer=programmer;
    }
    @Override
    public void run() {
        programmer.computer();
    }
}

//上厕所线程
class wcThread extends Thread{
    private Programmer programmer;
    public wcThread(Programmer programmer){
        this.programmer=programmer;
    }
    @Override
    public void run() {
        programmer.wc();
    }
}

//领取季度奖线程
class moneyThread extends Thread{
    private Programmer programmer;
    public moneyThread(Programmer programmer){
        this.programmer=programmer;
    }

    @Override
    public void run() {
        programmer.money();
    }
}


public class TestSyncThread {
    public static void main(String[] args) {
        /*Programmer programmer =new Programmer("郭家旗");
        Programmer programmer2 =new Programmer("王旭伟");

        new moneyThread(programmer).start();
        new moneyThread(programmer2).start();

        new saleMoneyThread(new sale("苏红润"),"苏红润").start();
        new saleMoneyThread(new sale("张晓燕"),"张晓燕").start();*/
        Manger manger =new Manger("张三丰");
        new cheersThread(manger,"张三").start();
        new cheersThread(manger,"李四").start();

    }
}
