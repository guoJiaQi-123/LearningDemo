package com.tyut.principles.richter_substitution.after;

/**
 * @author HX 2024/02/18
 * @version v1.0
 * @apiNote 长方形实体类
 */
public class Rectangle implements Quadrilateral {

    private double length;
    private double width;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getLength() {
        return this.length;
    }

    @Override
    public double getWidth() {
        return this.width;
    }
}
