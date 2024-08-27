package com.tyut.pattern._02_structure_model.e03decorator;

/**
 * @author OldGj 2024/02/25
 * @version v1.0
 * @apiNote 测试类 - 客户端
 */
public class Client {
    public static void main(String[] args) {


        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + "\t" + food.cost() + "元");
        System.out.println("-------------------");
        food = new Egg(food);
        System.out.println(food.getDesc() + "\t" + food.cost() + "元");
        System.out.println("-------------------");
        food = new Bacon(food);
        System.out.println(food.getDesc() + "\t" + food.cost() + "元");

    }
}
