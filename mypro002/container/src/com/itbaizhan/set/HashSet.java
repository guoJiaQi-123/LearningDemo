package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：HashSet容器(无序，无重复)

Set特点：无序、不可重复
 */

import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        //实例化一个HashSet容器
        Set<String> set =new java.util.HashSet<>();

        //增加元素
        boolean a = set.add("a");
        boolean b = set.add("b");
        boolean c = set.add("c");
        boolean a1 = set.add("a");
        System.out.println(a+"\t"+b+"\t"+c+"\t"+a1);

        for (String str:set){
            System.out.println(str);
        }

        //删除元素
        boolean remove = set.remove("b");
        System.out.println(remove);
        for(String str: set){
            System.out.println(str);
        }
        System.out.println("------------------------");
        int size = set.size();
        System.out.println(size);
    }
}
