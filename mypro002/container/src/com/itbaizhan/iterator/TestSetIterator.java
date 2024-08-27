package com.itbaizhan.iterator;/*
 *作者：郭家旗
 *时间：2023/09/11
 *本类内容：测试Set容器类的迭代器Iterator
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSetIterator {
    public static void main(String[] args) {
        //实例化一个Set类型容器
        Set<String> set =new HashSet<>();
        //添加元素
        set.add("e");
        set.add("b");
        set.add("a");
        set.add("d");
        set.add("c");
        //方式一：通过迭代器中的while循环迭代Set容器内的元素
        //获取迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String value = iterator.next();
            System.out.println(value);
        }
        System.out.println("--------------");
        //方式二：利用迭代器中的for循环迭代容器中的元素
        for (Iterator<String> iterator1 = set.iterator();iterator1.hasNext();){
            String value = iterator1.next();
            System.out.println(value);
        }

    }

}

