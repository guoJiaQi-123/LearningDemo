package com.tyut.principles.richter_substitution.before;

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

        //创建正方形对象
        Square square = new Square();
        square.setLength(10);
        resize(square);
        // 此时会进入死循环，因此Square类和Rectangle类之间的继承关系违反了里氏代换原则，它们之间的继承关系不成立，正方形不是长方形。
        printLengthAndWidth(square);
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
     * @param rectangle 长方形对象
     */
    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println("长："+rectangle.getLength());
        System.out.println("宽："+rectangle.getWidth());
    }
}
