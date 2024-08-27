package com.tyut.pattern._03_behavior_model.e03order;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 厨师类 - 命令接收者
 */
public class SeniorChef {

    public void createFood(int num, String food) {
        System.out.println(num + "份" + food );
    }

}
