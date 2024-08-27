package com.itbaizhan.list;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：LinkdeList(List标准)
 */

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        //实例化一个LinkedList容器
        List<String> list=new LinkedList<>();

        //添加元素
        boolean add1 = list.add("a");
        boolean add2 = list.add("b");
        boolean add3 = list.add("c");
        boolean add4 = list.add("c");
        boolean add5 = list.add("c");
        System.out.println(add1+"\t"+add2+"\t"+add3);

        //删除元素
        list.remove("b");
        list.remove(3);

        //修改元素
        list.set(0,"f");

        //遍历
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
