package com.tyut.pattern._01_creative_model.e02factor.before;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类
 */
public class Client {


    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");
        coffee.addMilk();
        coffee.addSugar();
        String name = coffee.getName();
        System.out.println(name);
    }

}
