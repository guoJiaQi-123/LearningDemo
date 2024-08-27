package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/02
 *本类内容：测试运行时异常（RuntimeException）
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {

    public static void main(String[] args) {

        //ArithmeticException异常：试图除以0
        int b=0;
        if(b!=0){
            System.out.println(1/b);
        }

        //NullPointerException异常:空指针异常
        String str=null;
        if(str!=null){
            System.out.println(str.charAt(0));
        }

        //ClassCastException异常:类型转换异常
        Animal animal = new cat();
        if(animal instanceof dog){
            dog dog = (dog)(animal);
        }

        //ArrayIndexOutOfBoundsException异常:数组越界异常
        int array[]=new int[5];
        int index=5;
        if(index>=0&&index<array.length){
            System.out.println(array[index]);
        }

        //NumberFormatException异常:数字转换异常
        String str2 = "1234abcf";
        Pattern p = Pattern.compile("^\\d+$");            //正则表达式解决数字转换异常
        Matcher m = p.matcher(str2);
        if (m.matches()) { // 如果str匹配代表数字的正则表达式,才会转换
            System.out.println(Integer.parseInt(str));
        }

    }
}
class Animal{

}
class dog extends Animal{

}
class cat extends Animal{

}