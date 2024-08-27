package com.tyut.pattern._02_structure_model.e03decorator;

/**
 * @author OldGj 2024/02/25
 * @version v1.0
 * @apiNote 抽象装饰者类
 */
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "培根");
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }
}
