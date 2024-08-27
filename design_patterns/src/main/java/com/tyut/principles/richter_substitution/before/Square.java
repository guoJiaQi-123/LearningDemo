package com.tyut.principles.richter_substitution.before;

/**
 * @author HX 2024/02/18
 * @version v1.0
 * @apiNote 正方形类
 */
public class Square extends Rectangle {

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }
}
