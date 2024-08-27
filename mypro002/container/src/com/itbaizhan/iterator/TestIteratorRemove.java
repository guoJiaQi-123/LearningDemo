package com.itbaizhan.iterator;/*
 *作者：郭家旗
 *时间：2023/09/11
 *本类内容：在迭代器中删除元素
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestIteratorRemove {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){ //不要在一次循环中多次调用next方法。
            iterator.next();
            iterator.remove();
        }
        for (String str:list){
            System.out.println(str);
        }
    }
}
