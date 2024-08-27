package com.tyut.pattern._02_structure_model.e07flyweight;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 客户端 - 测试类
 */
public class Client {

    public static void main(String[] args) {
        BoxFactory factory = BoxFactory.getInstance();
        AbstractBox LBox = factory.createBox("L");
        LBox.display("红色"); // 外部状态

        AbstractBox oBox = factory.createBox("O");
        oBox.display("黑色"); // 外部状态

        AbstractBox IBox = factory.createBox("I");
        IBox.display("白色"); // 外部状态

        AbstractBox IBox2 = factory.createBox("I");
        IBox2.display("蓝色"); // 外部状态
        System.out.println("是否共享同一个对象：" + (IBox == IBox2));
    }


}
