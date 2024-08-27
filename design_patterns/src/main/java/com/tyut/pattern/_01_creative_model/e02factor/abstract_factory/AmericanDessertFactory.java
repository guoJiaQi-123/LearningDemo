package com.tyut.pattern._01_creative_model.e02factor.abstract_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 具体工厂 - 美式风味甜点
 */
public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
