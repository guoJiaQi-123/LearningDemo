package com.tyut.pattern._01_creative_model.e04builder.demo1;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 指挥者
 */
public class Direct {

    private final Builder builder;

    public Direct(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.creatBike();
    }
}
