package com.tyut.pattern._01_creative_model.e04builder.demo1;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 具体建造者 - ofo单车
 */
public class OfoBuilder extends  Builder{


    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("牛皮车座");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
