package com.tyut.pattern._01_creative_model.e04builder.demo1;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 抽象建造者 - 定义建造复杂对象各个部件的方法
 */
public abstract class Builder {

    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike creatBike();

}
