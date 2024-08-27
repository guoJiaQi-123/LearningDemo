package com.itbaizhan.InnerClass;
/*测试静态内部类*/
public class TestStaticInnerClass {
    public static void main(String[ ] args) {
        //通过 new 外部类名.内部类名() 来创建内部类对象
        Outer2.Inner2 inner =new Outer2.Inner2();
        inner.test();
    }
}
