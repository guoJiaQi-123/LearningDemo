package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：调试IDEA  断点测试
 */

public class TestBreakPoint {
    private int num=10;

    public void run(int a){
        for(int i=0;i<a;i++){
            System.out.println("TestBreakPoint.run");
            num+=a;
            go();
        }
    }
    public void go(){
        System.out.println("TestBreakPoint.go");
        System.out.println("num="+num);
    }

    public static void main(String[] args) {
        new TestBreakPoint().run(5);
    }
}
