package com.itbaizhan.iterator;/*
 *作者：郭家旗
 *时间：2023/09/11
 *本类内容：测试List容器类的迭代器Iterator
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestListIterator {
    public static void main(String[] args) {
        //实例化一个List容器
        List<String> list =new ArrayList<>();

        //添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        //方式一：通过迭代器中的while循环迭代容器
        //获取迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
        }
        System.out.println("************");
        //通过for循环来迭代容器中的元素
        for (Iterator<String> iterator2 = list.iterator();iterator2.hasNext();){
            String value2 = iterator2.next();
            System.out.println(value2);
        }

    }
}
