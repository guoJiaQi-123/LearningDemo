package com.tyut.pattern._01_creative_model.e03prototype.demo3;

import java.io.Serializable;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 奖状类
 */
public class Citation implements Cloneable, Serializable {
    private Student student;

    public void show() {
        System.out.println(student.getName() + "获得了奖状");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
}
