package com.itbaizhan.abstractClass;
/*
*          测试抽象类
* 抽象类的使用要点:

有抽象方法的类只能定义成抽象类
抽象类不能实例化，即不能用new来实例化抽象类。
抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用。
抽象类只能用来被继承。
抽象方法必须被子类实现。
   * */
public abstract class Animal {
    int age;
    String name;
    public abstract void rest();
    public abstract void run();

}
class Dog extends Animal{
    public void rest(){
        System.out.println("休息");
    }
    public void run(){
        System.out.println("跑");
    }
}

