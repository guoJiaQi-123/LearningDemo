public class HomeWork04 {

    public static void main(String[] args) {
        Car c1 = new Car();                  //声明了一个Car类型的对象c1
        c1.changeColor("红色");            //通过调用c1的changeColor方法将c1的color变量赋值为“红色”
        c1.showColor();                      //通过调用c1的showColor方法打印：我的颜色是：红色
        System.out.println(Car.tyreNum);     //打印Car的静态变量tyreNum  （静态变量可以使用类名调用）
        System.out.println(c1.tyreNum);      //打印Car的静态变量tyreNum  (因为静态变量是从属于类的，也叫类变量)
        Car c2 = new Car();                  //声明了一个Car类型的对象c2
        Engine e = new Engine();             //声明了一个Engine类型的对象e
        e.speed = 1000;                      //e的speed属性赋值为：1000
        e.weight = 10;                       //e的weight属性赋值为：10
        c2.engine = e;                       //c2的engine属性赋值为e变量
        c2.color = "黑色";
        c2.tyreNum = 10;                      //通过c2修改了静态变量的值，则静态变量在全局全部发生修改
        System.out.println(c1.tyreNum);//静态变量的改变是全局的，会影响到所有使用该静态变量的地方。
    }
}

class Car {                                   //定义一个Car类
    static int tyreNum = 4;                   //Car类的静态变量
    Engine engine;                            //成员变量
    String color; // char sequence :字符序列

    void changeColor(String c) {              //普通方法：调用时将形参C的值赋值给color变量
        color = c;
    }

    void showColor() {                        //普通方法：调用时打印我的颜色是：color的值
        System.out.println("我的颜色是：" + color);
    }
}

class Engine {                               //定义了Engine类
    int speed;                               //声明成员变量
    int weight;
}