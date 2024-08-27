/*

        *1.定义一个“点”（Point）类用来表示二维空间中的点（有两个坐标）。要求如下：
        *2.可以生成具有特定坐标的点对象。
        *3.提供可以计算该“点”距另外一点距离的方法。
 */
public class Point {
    double x ,y;   //定义Point类的属性

    Point(double _x,double _y){        //构造器
        x = _x;
        y = _y;
    }
    public double getDistance(Point p2){    //提供方法  用一个点的坐标当做形式参数
        return Math.sqrt((x- p2.x)*(x- p2.x)+(y- p2.y)*(y- p2.y));
    }

    public static void main(String[] args) {
        Point p1 = new Point(3.0,4.0);   //定义两个点  并通过构造器给两个的坐标赋初始值
        Point Origin = new Point(0.0,0.0);
        System.out.println(p1.getDistance(Origin));  //实参也输入一个点的坐标

    }

}
