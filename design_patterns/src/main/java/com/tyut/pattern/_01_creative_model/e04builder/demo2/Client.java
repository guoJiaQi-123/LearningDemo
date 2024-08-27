package com.tyut.pattern._01_creative_model.e04builder.demo2;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 测试类
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("x")
                .mainboard("华硕")
                .memory("金士顿")
                .screen("三星")
                .build();
        System.out.println(phone);

    }
}
