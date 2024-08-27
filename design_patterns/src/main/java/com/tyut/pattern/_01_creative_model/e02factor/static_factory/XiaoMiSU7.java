package com.tyut.pattern._01_creative_model.e02factor.static_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 小米SU7抽象类
 */
public abstract class XiaoMiSU7 {

    public void run(){
        System.out.println("百公里加速2.78");
    }

    public void stop(){
        System.out.println("黄色刹车盘");
    }

    // 获取配置
    public abstract String getDisposition();

}
