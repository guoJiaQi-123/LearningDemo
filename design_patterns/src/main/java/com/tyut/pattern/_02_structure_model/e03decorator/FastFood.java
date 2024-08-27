package com.tyut.pattern._02_structure_model.e03decorator;

/**
 * @author OldGj 2024/02/25
 * @version v1.0
 * @apiNote 快餐类 - 抽象构件者
 */
public abstract class FastFood {

    private float price;
    private String desc;

    public FastFood() {
    }



    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public abstract float cost();  //获取价格

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
