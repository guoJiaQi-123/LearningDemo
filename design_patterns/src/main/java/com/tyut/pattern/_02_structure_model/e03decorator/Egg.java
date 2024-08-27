package com.tyut.pattern._02_structure_model.e03decorator;

/**
 * @author OldGj 2024/02/25
 * @version v1.0
 * @apiNote 鸡蛋类 - 具体装饰者
 */
public class Egg extends Garnish {


    @Override
    public String getDesc() {
        return super.getDesc()+getFastFood().getDesc();
    }

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }
}
