package com.tyut.pattern._03_behavior_model.e01template;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 客户端类 - 测试
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();
        System.out.println("-------------------");
        AbstractClass caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
