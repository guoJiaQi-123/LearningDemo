package com.tyut.principles.richter_substitution.after;



/**
 * @author HX 2024/02/18
 * @version v1.0
 * @apiNote 主方法测试类
 */
public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle rectangle = new Rectangle();
        // 为长方形对象设置长和宽
        rectangle.setLength(20);
        rectangle.setWidth(10);
        // 调用resize方法实现拓宽操作
        resize(rectangle);
        printLengthAndWidth(rectangle);

    }

    /**
     * 拓宽操作
     */
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    /**
     * 打印长方形的长和宽
     *
     * @param rectangle 长方形对象
     */
    public static void printLengthAndWidth(Quadrilateral quadrilateral) {
        System.out.println("长：" + quadrilateral.getLength());
        System.out.println("宽：" + quadrilateral.getWidth());
    }
}
