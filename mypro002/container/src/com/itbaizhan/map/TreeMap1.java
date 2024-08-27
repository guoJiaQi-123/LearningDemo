package com.itbaizhan.map;/*
 *作者：郭家旗
 *时间：2023/09/10
 *本类内容：TreeMap容器  利用元素自身比较规则进行key的排序
 */

import com.itbaizhan.set.User;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {

    public static void main(String[] args) {
        //实例化
        Map<User,String> map=new TreeMap<>();

        //实例化User
        User user =new User("guojiaqi",20);
        User user2 =new User("suhongrun",19);
        User user3=new User("wangxuwei",20);
        //添加
        map.put(user, user.getUser());
        map.put(user2, user2.getUser());
        map.put(user3, user3.getUser());
        //遍历
        Set<User> keySet = map.keySet();
        for (User key:keySet){
            System.out.println(key+"--"+map.get(key));
        }
    }
}
