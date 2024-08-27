package com.itbaizhan.InnerClass;

/**
 * 测试匿名内部类
 */
public class TestAnonymousInnerClass {
    public void test1(A a) {
        a.run();
    }


    public static void main(String[] args) {
        TestAnonymousInnerClass tac = new TestAnonymousInnerClass();
        tac.test1(new A() {
            @Override
            public void run() {
                System.out.println("匿名内部类测试!  我是新定义的第一个匿名内部类！");
            }
        });




        tac.test1(new A() {
            @Override
            public void run() {
                System.out.println("我是新定义的第二个匿名内部类");
            }
        });


    }


}
interface A {
    void run();
}

