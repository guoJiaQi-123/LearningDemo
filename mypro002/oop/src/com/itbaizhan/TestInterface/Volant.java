package com.itbaizhan.TestInterface;
//飞行接口
public interface Volant {
    /*public static final */   int FLY_HIGHT = 100;
    /*public abstract */       void fly();
}
interface Honest{
    void helpOther();
}
class BirdMan implements Volant{

    @Override
    public void fly() {
        System.out.println("鸟人在飞");
    }
}
class angel implements Honest,Volant{

    @Override
    public void fly() {
        System.out.println("天使不但会飞");
    }

    @Override
    public void helpOther() {
        System.out.println("天使还很善良");
    }
}