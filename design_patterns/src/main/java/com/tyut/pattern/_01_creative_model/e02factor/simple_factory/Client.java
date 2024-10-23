package com.tyut.pattern._01_creative_model.e02factor.simple_factory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 客户
 */
public class Client {
    public static void main(String[] args) {
        MI4S mi4S = new MI4S();
        XiaoMiSU7 xiaoMiSU7 = mi4S.orderXiaoMiSU7("high");

        System.out.println(xiaoMiSU7.getDisposition());
    }
}
