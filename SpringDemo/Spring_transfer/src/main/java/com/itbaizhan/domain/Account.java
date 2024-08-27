package com.itbaizhan.domain;

//账户实体类
public class Account {
    private int id;//用户id
    private String username;//用户名
    private double balance;//用户余额

    public Account() {
    }

    public Account(int id, String username, double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
