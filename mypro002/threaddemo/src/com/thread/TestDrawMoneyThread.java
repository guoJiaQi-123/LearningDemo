package com.thread;/*
 *作者：郭家旗
 *时间：2023/09/19
 *本类内容：
 */

/**
 * 银行类
 */
class Bank{//银行账户类
    private String Account;//用户名
    private Double Balance;//账户余额

    public Bank() {
    }

    public Bank(String account, Double balance) {//构造方法初始化用户名和账户余额
        Account = account;
        Balance = balance;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }
}

/**
 * 取钱线程
 */
class DrawMoney implements Runnable{
    private Bank bank;//在哪个银行账户取钱
    private Double DrawMoney;//取多少钱

    public DrawMoney(Bank bank, Double DrawMoney) {//初始化账户和取钱金额
        this.bank = bank;
        this.DrawMoney = DrawMoney;
    }

    @Override
    public void run() {
        synchronized (this.bank){
        if (this.bank.getBalance()>=this.DrawMoney){//判断当前账户的余额是否够取钱金额
            System.out.println(Thread.currentThread().getName()+" 取款成功,吐出钞票"+this.DrawMoney);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.bank.setBalance(this.bank.getBalance()-this.DrawMoney);//计算账户取钱后的余额
            System.out.println("您的余额还剩："+this.bank.getBalance());
        }else {
            System.out.println(Thread.currentThread().getName()+"取款失败，余额不足");
            }
        }
    }
}

public class TestDrawMoneyThread {
    public static void main(String[] args) {
        Bank bank =new Bank("guojiaqi",5000.0);
        //Bank bank2 =new Bank("suhongrun",8000.0);
        new Thread(new DrawMoney(bank,4000.0),"郭家旗取钱").start();//启动郭家旗取钱线程
        new Thread(new DrawMoney(bank,5000.0),"苏红润取钱").start();//启动苏红润取钱线程

    }
}
