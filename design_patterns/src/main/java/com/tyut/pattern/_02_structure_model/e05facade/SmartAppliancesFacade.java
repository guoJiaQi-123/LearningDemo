package com.tyut.pattern._02_structure_model.e05facade;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 外观角色 - 智能语言助手类
 */
public class SmartAppliancesFacade {

    private final TV tv;
    private final Light light;
    private final AirCondition airCondition;



    public SmartAppliancesFacade() {
        tv = new TV();
        airCondition = new AirCondition();
        light = new Light();
    }

    public void say(String message) {
        if(message.contains("打开")) {
            on();
        } else if(message.contains("关闭")) {
            off();
        } else {
            System.out.println("我还听不懂你说的！！！");
        }
    }
    // 一键开启家电
    private void on(){
        tv.on();
        airCondition.on();
        light.on();
    }

    // 一键关闭家电
    private void off(){
        tv.off();
        airCondition.off();
        light.off();
    }
}
