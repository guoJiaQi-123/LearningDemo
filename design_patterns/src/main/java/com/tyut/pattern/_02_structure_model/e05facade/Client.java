package com.tyut.pattern._02_structure_model.e05facade;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {
    public static void main(String[] args) {
        // 创建外观对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        // 客户端直接与外观对象进行交互
       facade.say("打开");
    }
}
