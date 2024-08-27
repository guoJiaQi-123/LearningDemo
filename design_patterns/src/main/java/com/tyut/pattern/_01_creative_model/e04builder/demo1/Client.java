package com.tyut.pattern._01_creative_model.e04builder.demo1;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {
    public static void main(String[] args) {

        Direct direct = new Direct(new OfoBuilder());
        Bike bike = direct.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());


    }
}
