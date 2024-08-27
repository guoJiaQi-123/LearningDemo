package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：通过HashSet存储自定义对象
 HashSet 是一个不保证元素的顺序且没有重复元素的集合，是线程不安全的。HashSet允许有null 元素。
无序：
在HashSet中底层是使用HashMap存储元素的。HashMap底层使用的是数组与链表实现元素的存储。
元素在数组中存放时，并不是有序存放的也不是随机存放的，而是对元素的哈希值进行运算决定元素在数组中的位置。
不重复：
当两个元素的哈希值进行运算后得到相同的在数组中的位置时，会调用元素的equals()方法判断两个元素是否相同。
如果元素相同则不会添加该元素，如果不相同则会使用单向链表保存该元素。


通过HashSet存储自定义对象一定要在自定义对象中重写hashCode()方法和equals()方法

 */
import java.util.Set;
public class HashSet1 {

    public static void main(String[] args) {
        //实例化一个HashSet容器
        Set<User> hashSet = new java.util.HashSet<>();

        //实例化User值
        User user = new User("郭家旗",20);
        User user1 = new User("郭家旗",20);
        //将自定义对象存储在HashSet容器中
        hashSet.add(user);
        hashSet.add(user1);

        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(user.equals(user1));

        for (User user2:hashSet){
            System.out.println(user2);
        }
    }
}
