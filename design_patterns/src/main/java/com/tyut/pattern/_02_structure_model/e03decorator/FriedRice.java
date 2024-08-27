package com.tyut.pattern._02_structure_model.e03decorator;

/**
 * @author OldGj 2024/02/25
 * @version v1.0
 * @apiNote 炒饭类 - 具体构件者（待装饰类）
 */
public class FriedRice extends FastFood {

    public FriedRice() {
        super(10, "炒饭");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
