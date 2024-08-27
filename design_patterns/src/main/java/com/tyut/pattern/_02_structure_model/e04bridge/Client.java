package com.tyut.pattern._02_structure_model.e04bridge;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {
    public static void main(String[] args) {
        OperatingSystemVersion systemVersion = new Window(new RMVBFile());
        systemVersion.play("战狼");
    }
}
