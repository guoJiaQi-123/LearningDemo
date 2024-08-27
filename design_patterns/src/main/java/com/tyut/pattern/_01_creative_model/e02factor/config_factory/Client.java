package com.tyut.pattern._01_creative_model.e02factor.config_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 客户端
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());

        System.out.println("****************************");
        Coffee coffee1 = CoffeeFactory.createCoffee("latte");
        System.out.println(coffee1.getName());
        System.out.println("****************************");
        Coffee coffee2 = CoffeeFactory.createCoffee("ku");
        System.out.println(coffee2.getName());
    }
}
