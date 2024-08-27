package com.itbaizhan.list;/*
 *作者：郭家旗
 *时间：2023/09/08
 *本类内容：Vector容器  线程安全，效率低
 */

import java.util.List;
import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {
        //实例化一个Vector容器
        List<String> v=new Vector<>();
        //增加元素
        v.add("a");
        v.add("b");
        v.add("c");
        v.add("d");
        //遍历Vector容器
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i));
        }

        System.out.println("******************");
        for (String s:v){
            System.out.println(s);
        }
    }
}
