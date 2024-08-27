package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：TreeSet实现了Set接口，它是一个可以对元素进行排序的容器。
 底层实际是用TreeMap实现的，内部维持了一个简化版的TreeMap，通过key来存储元素。
 TreeSet内部需要对存储的元素进行排序，因此，我们需要给定排序规则。
排序规则实现方式：
• 1.通过元素自身实现比较规则。
• 2.通过比较器指定比较规则。

 */

import java.util.Set;
import java.util.TreeSet;

public class TreeSet0 {

    public static void main(String[] args) {
        //实例化一个TreeSet容器
        Set<String> set=new TreeSet<>();

        //添加元素
        set.add("c");
        set.add("a");
        set.add("b");
        set.add("a");

        for(String str:set){
            System.out.println(str);
        }
    }
}
