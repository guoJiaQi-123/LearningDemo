package com.itbaizhan.TestInterface;
//测试接口中的新特性，默认方法！！！静态方法！！！
public class test {
    public static void main(String[] args) {
        angel a = new angel();
        a.fly();
        a.helpOther();
        System.out.println(Volant.FLY_HIGHT);

        System.out.println("========测试默认方法==========");
        TestDefault td = new TestDefault01();
        td.PrintInfo();
        td.moren();

        System.out.println("=========测试静态方法============");
        TestDefault.TestStatic();      //直接用接口名去调用
        //如果子类中定义了相同名字的静态方法，那就是完全不同的方法了，直接从属于子类。可以通过子类名直接调用。
        TestDefault01.TestStatic();

    }

}
