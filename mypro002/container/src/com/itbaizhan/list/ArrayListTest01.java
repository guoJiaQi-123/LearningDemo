package com.itbaizhan.list;/*
 *作者：郭家旗
 *时间：2023/09/08
 *本类内容：ArrayList的索引操作
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest01 {
    public static void main(String[] args) {
        //实例化一个ArrayList容器
        List<String> list=new ArrayList<>();

        //添加元素
        list.add("gjq");
        list.add("shr");
        list.add("itbz");
        //利用索引添加元素
        list.add(0,"hhxx");

        //将容器转换为数组，进行打印
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        //利用索引删除元素   返回被删除的值
        System.out.println("利用索引删除元素   返回被删除的值");
        String remove = list.remove(3);
        System.out.println(remove);

        //利用索引替换元素的值  返回被替换的值
        System.out.println("利用索引替换元素的值  返回被替换的值");
        String set = list.set(0, "nbkls");
        System.out.println(set);

        //利用索引获取元素
        System.out.println("获取元素");
        String s = list.get(0);
        System.out.println(s);

        //获取所有元素
        System.out.println("获取所有元素1");
        for(int i=0;i<list.size();i++){
            String s1 = list.get(i);
            System.out.println(s1);
        }
        System.out.println("获取所有元素2");
        for (String string:list){
            System.out.println(string);
        }
        list.add(3,"nbkls");

        //输出指定元素的第一个位置和最后一个位置
        System.out.println("输出指定元素的第一个位置和最后一个位置");
        int nbkls = list.indexOf("nbkls");
        int nbkls1 = list.lastIndexOf("nbkls");
        System.out.println(nbkls);
        System.out.println(nbkls1);
    }
}
