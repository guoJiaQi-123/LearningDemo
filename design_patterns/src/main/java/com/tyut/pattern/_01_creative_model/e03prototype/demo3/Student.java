package com.tyut.pattern._01_creative_model.e03prototype.demo3;

import java.io.Serializable;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 学生类
 */
public class Student implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
