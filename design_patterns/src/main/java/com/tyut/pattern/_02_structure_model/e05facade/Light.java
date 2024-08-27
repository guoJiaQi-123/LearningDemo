package com.tyut.pattern._02_structure_model.e05facade;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 子系统角色 - 电灯类
 */
public class Light {

    public void on(){
        System.out.println("打开电灯...");
    }

    public void off(){
        System.out.println("关闭电灯...");
    }

}
