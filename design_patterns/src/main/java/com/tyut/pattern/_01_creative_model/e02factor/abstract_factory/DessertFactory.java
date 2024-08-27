package com.tyut.pattern._01_creative_model.e02factor.abstract_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 抽象工厂  -  甜点接口
 */
public interface DessertFactory {
    Dessert createDessert();

    Coffee createCoffee();
}
