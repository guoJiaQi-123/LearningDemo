package com.tyut.pattern._01_creative_model.e03prototype.demo2;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 抽象原型 - 奖状类
 */
public class Citation implements Cloneable {

    private String name;

    public void show() {
        System.out.println(name + "获取了奖状");
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
