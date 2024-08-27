package com.tyut.principles.demeter_rule;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 粉丝类
 */
public class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
