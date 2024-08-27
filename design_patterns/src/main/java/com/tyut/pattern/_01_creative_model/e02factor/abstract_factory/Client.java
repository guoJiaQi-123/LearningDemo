package com.tyut.pattern._01_creative_model.e02factor.abstract_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 客户端
 */
public class Client {
    public static void main(String[] args) {
        DessertFactory factory = new ItalyDessertFactory();
        Coffee coffee = factory.createCoffee();
        System.out.println(coffee.getName());
        Dessert dessert = factory.createDessert();
        System.out.println(dessert.getName());
    }
}
