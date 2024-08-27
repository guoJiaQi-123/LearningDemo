package com.tyut.pattern._03_behavior_model.e01template;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 具体子类 - 炒包菜
 */
public class ConcreteClass_BaoCai extends AbstractClass{
    @Override
    public void pourVegetable() {
        System.out.println("炒的菜是包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("调味品是：辣椒");
    }
}
