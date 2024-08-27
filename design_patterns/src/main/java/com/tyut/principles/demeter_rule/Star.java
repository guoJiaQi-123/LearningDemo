package com.tyut.principles.demeter_rule;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 明星实体类
 */
public class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
