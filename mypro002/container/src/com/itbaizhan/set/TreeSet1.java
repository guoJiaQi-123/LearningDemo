package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：TreeSet容器通过元素自身实现比较规则
 */

import java.util.Set;
import java.util.TreeSet;

public class TreeSet1 {

    public static void main(String[] args) {
        //实例化一个TreeSet容器
        Set<User> set =new TreeSet<>();

        //实例化User对象
        User user1 = new User("郭家旗",20);
        User user2 = new User("苏红润",19);
        User user3 = new User("王旭伟",20);

        //将对象传入到容器中
        set.add(user1);
        set.add(user2);
        set.add(user3);

        //遍历容器，打印                                   //如果TreeSet容器没有比较规则
        for (User user:set){           //如果在User类中没有定义Comparable接口的CompareTo方法则报.ClassCastException异常
            System.out.println(user);
        }
    }
}
