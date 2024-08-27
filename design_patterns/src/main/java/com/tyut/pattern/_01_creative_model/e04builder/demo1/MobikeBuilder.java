package com.tyut.pattern._01_creative_model.e04builder.demo1;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 具体建造者 - 摩拜单车
 */
public class MobikeBuilder extends Builder {


    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车座");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
