package com.itbaizhan.iterator;/*
 *作者：郭家旗
 *时间：2023/09/11
 *本类内容：测试Map容器类的迭代器Iterator
            迭代器Iterator不能直接迭代双例集合，但是可以迭代Map容器生成的keySet等容器
 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMapIterator {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("a","A");
        map.put("b","B");
        map.put("c","C");
        map.put("d","D");

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
        }
        System.out.println("******************");
        for (Iterator<String> iterator1 = keySet.iterator();iterator1.hasNext();){
            String key = iterator1.next();
            System.out.println(key);
        }
        System.out.println("*--*-*-*-*-*-*-*-*-*-*-");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> entry = iterator1.next();
            System.out.println(entry);
        }
        System.out.println("******************");
        for (Iterator<Map.Entry<String, String>> iterator2 = entrySet.iterator();iterator2.hasNext();){
            Map.Entry<String, String> entry = iterator2.next();
            System.out.println(entry);
        }
    }
}
