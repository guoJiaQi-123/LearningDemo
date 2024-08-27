package com.tyut.pattern._01_creative_model.e03prototype.demo1;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 具体原型模式
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("原型创建");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("原型克隆");
        return (Realizetype) super.clone();
    }

}
