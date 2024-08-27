package com.tyut.pattern._02_structure_model.e07flyweight;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 享元设计模式 - 抽象享元类
 */
public abstract class AbstractBox {

    public abstract String getSharp();

    public void display(String color) {
        System.out.println("形状：" + this.getSharp() + "，颜色：" + color);
    }
}
