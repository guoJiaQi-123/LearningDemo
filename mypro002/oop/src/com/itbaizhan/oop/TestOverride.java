package com.itbaizhan.oop;

public class TestOverride {
    public static void main(String[] args) {
        House h1=new House();
        h1.run();
        h1.getVehicle();
        plane p1=new plane();
        p1.run();
    }
}
class Vehicle{
    public void run(){
        System.out.println("跑-----");
    }

    public Vehicle getVehicle(){
        System.out.println("得到一个交通工具！！");
        return null;
    }
}
class House extends Vehicle{
    @Override
    public void run() {

        System.out.println("得得得----");
    }
}
class plane extends Vehicle{
    @Override
    public void run() {
        System.out.println("飞----");
    }
}