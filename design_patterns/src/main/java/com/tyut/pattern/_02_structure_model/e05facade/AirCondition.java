package com.tyut.pattern._02_structure_model.e05facade;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 子系统 - 空调类
 */
public class AirCondition {
    public void on(){
        System.out.println("打开空调...");
    }

    public void off(){
        System.out.println("关闭空调...");
    }
}
