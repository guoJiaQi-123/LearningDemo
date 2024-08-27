package com.itbaizhan.list;/*
 *作者：郭家旗
 *时间：2023/09/07
 *本类内容：ArrayList容器
 */

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        //实例化一个ArrayList对象
        List<String> list = new ArrayList<>();

        //添加元素
        boolean flag1 = list.add("傻");
        boolean flag2 = list.add("苏");
        boolean flag3 = list.add("红");
        boolean flag4 = list.add("润");
        System.out.println(flag1+"\t"+flag2+"\t"+flag3+"\t"+flag4);

        //删除容器中的元素
        boolean remove = list.remove("苏");
        System.out.println(remove);

        //容器中是否包含指定的元素
        boolean contains = list.contains("傻");
        System.out.println(contains);

        //查询容器中元素的个数
        int size = list.size();
        System.out.println(size);

        //判断容器是否为空
        boolean empty = list.isEmpty();
        System.out.println(empty);
        
        //修改指定下标位置的元素，返回原来的元素
        String set = list.set(2, "哈");
        System.out.println(set);

        //将ArrayList容器转换为数组
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        //清空容器
        list.clear();

        boolean empty1 = list.isEmpty();
        System.out.println(empty1);
    }
}
