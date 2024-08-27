package com.tyut.pattern._01_creative_model.e02factor.factory_method;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 客户
 */
public class Client {
    public static void main(String[] args) {

        //创建4S店
        MI4S mi4S = new MI4S();
        //创建高配小米SU7工厂
        XiaoMiSU7Factory factory = new HighXiaoMiSU7Factory();
        MiddleXiaoMiSU7Factory miSU7Factory = new MiddleXiaoMiSU7Factory();
        mi4S.setFactory(miSU7Factory);
        XiaoMiSU7 xiaoMiSU7 = mi4S.orderXiaoMiSU7();
        System.out.println(xiaoMiSU7.getDisposition());

    }
}
