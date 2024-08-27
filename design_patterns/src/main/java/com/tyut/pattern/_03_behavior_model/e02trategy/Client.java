package com.tyut.pattern._03_behavior_model.e02trategy;

/**
 * @author OldGj 2024/03/08
 * @version v1.0
 * @apiNote 客户端类 - 测试类
 */
public class Client {
    public static void main(String[] args) {
        // ------------策略一：
        Context context = new Context(new StrategyA());
        context.show();
        // ------------策略二：
        context.setStrategy(new StrategyB());
        context.show();
        // ------------策略三：
        context.setStrategy(new StrategyC());
        context.show();
    }
}
