package com.tyut.pattern._03_behavior_model.e01template;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 具体子类 - 炒菜心
 */
public class ConcreteClass_CaiXin extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("炒的菜品是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("调味料是：蒜蓉");
    }
}
