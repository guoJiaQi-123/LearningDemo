package com.itbaizhan.TestInterface;

public interface TestDefault {
    void PrintInfo();
    default void moren(){//测试默认方法
        System.out.println("TestDefault.moren");
        System.out.println("测试默认方法*-*-*-*-*-*-*-");
        TestDefault.TestStatic();//默认方法中可以调用静态方法
    }
    //这个静态方法直接从属于接口（接口也是类，一种特殊的类），可以通过接口名调用
    public static void TestStatic(){//测试静态方法
        System.out.println("TestDefault.TestStatic");
        //TestDefault.moren;    //静态方法中不能调用默认方法
    }
}
class TestDefault01 implements TestDefault{
    public void PrintInfo(){
        System.out.println("TestDefault01.PrintInfo");
    }
    public static void TestStatic(){
        System.out.println("TestDefault01.TestStatic");
    }

}