package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/04
 *本类内容：String陷阱   ！！！
 */

public class TestString2 {

    public static void main(String[] args) {
        /*使用String进行字符串的拼接*/
        String s1="";
        long num1=Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time1= System.currentTimeMillis();//获取系统的当前时间
        for (int i=0;i<5000;i++){
            s1=s1+i;                            //会产生5000个对象
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("系统消耗的空间："+(num1-num2));
        System.out.println("系统消耗的时间："+(time2-time1));

        /*使用StringBuildier进行添加字符*/
        StringBuilder s2=new StringBuilder("");
        long num3=Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time3= System.currentTimeMillis();//获取系统的当前时间
        for(int i=0;i<5000;i++){
            s2.append(i);                      //只有这一个对象
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("系统消耗的空间："+(num3-num4));
        System.out.println("系统消耗的时间："+(time4-time3));
    }
}
