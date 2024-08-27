package com.tyut.principles.richter_substitution.after;

/**
 * @author HX 2024/02/18
 * @version v1.0
 * @apiNote 正方形实体类
 */
public class Square implements Quadrilateral {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return this.side;
    }

    @Override
    public double getWidth() {
        return this.side;
    }
}
