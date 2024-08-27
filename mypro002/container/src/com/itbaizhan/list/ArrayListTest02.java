package com.itbaizhan.list;/*
 *作者：郭家旗
 *时间：2023/09/08
 *本类内容：ArrayList容器的并集，交集，差集操作
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest02 {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("b");
        b.add("c");

        //并集操作  addAll
        a.addAll(b);
        for (String s:a){
            System.out.println(s);
        }
        System.out.println("*****************");

        List<String> a1 = new ArrayList<>();
        a1.add("a");
        a1.add("b");
        a1.add("d");
        List<String> b1 = new ArrayList<>();
        b1.add("a");
        b1.add("b");
        b1.add("c");

        //交集操作   retainAll
        a1.retainAll(b1);
        for(String s1:a1){
            System.out.println(s1);
        }

        System.out.println("*************************");
        List<String> a2 = new ArrayList<>();
        a2.add("a");
        a2.add("b");
        a2.add("d");
        List<String> b2 = new ArrayList<>();
        b2.add("a");
        b2.add("b");
        b2.add("c");

        //差集操作   removeAdd
        a2.removeAll(b2);
        for (String s2:a2){
            System.out.println(s2);
        }
    }
}
