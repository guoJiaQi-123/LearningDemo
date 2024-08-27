package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：第一个泛型
 */

public class generic<T>{
    private T str;              //定义一个str  数据类型先用泛型暂时占位

    public void setStr(T str){  //generic 类下的set方法
        this.str=str;
    }

    public T getStr(){         //generic 类下的get方法
        return this.str;
    }

    public static void main(String[] args) {
        generic<String> generic=new generic<>();
        generic.setStr("郭家旗爱苏红润");
        String s=generic.getStr();
        System.out.println(s);

        generic<Integer> generic1 = new generic<>();
        generic1.setStr(520);
        int i = generic1.getStr();
        System.out.println(i);
    }
}
