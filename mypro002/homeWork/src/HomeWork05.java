//设计一个类代表二维空间的一个圆。要求两个成员变量。一个是圆心，一个是半径提供计算面积的方法。
public class HomeWork05 {
    public static void main(String[] args) {
        point p=new point(1,1);
        circle c1=new circle(p,2);
        c1.area();
    }
}
class circle{  //圆类
    point o;  //圆心
    int r;    //半径
    public circle(point o, int r) {//构造器对成员变量进行初始化
        this.o = o;
        this.r = r;
    }
    void area(){                   //计算面积的方法
        double area1 = Math.PI * r * r;
        System.out.println(area1);
    }
}
class point{                        //点类
    int i;
    int j;

    public point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}