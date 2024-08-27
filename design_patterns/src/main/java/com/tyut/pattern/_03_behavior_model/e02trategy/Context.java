package com.tyut.pattern._03_behavior_model.e02trategy;

/**
 * @author OldGj 2024/03/08
 * @version v1.0
 * @apiNote 环境类 - 聚合策略类供外界调用
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void show(){
        strategy.show();
    }
}
