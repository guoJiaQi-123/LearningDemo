package com.tyut.pattern._02_structure_model.e03decorator;

/**
 * @author OldGj 2024/02/25
 * @version v1.0
 * @apiNote 炒面类 - 具体构件者（待装饰类）
 */
public class FriedNoodles extends FastFood {


    public FriedNoodles(){
        super(12,"炒面");
    }


    @Override
    public float cost() {
        return getPrice();
    }
}
