package com.tyut.pattern._01_creative_model.e02factor.before;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 咖啡类
 */
public abstract class Coffee {
    public void addSugar(){
        System.out.println("加糖");
    }

    public void addMilk(){
        System.out.println("加奶");
    }

    public abstract String getName();
}
