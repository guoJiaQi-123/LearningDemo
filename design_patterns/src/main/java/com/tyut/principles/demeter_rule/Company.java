package com.tyut.principles.demeter_rule;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 媒体公司类
 */
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
