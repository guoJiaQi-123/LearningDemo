package com.tyut.pattern._01_creative_model.e02factor.before;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 咖啡店
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有该类型咖啡");
        }
        return coffee;
    }


}
