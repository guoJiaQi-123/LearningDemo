package com.itbaizhan.list;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：LinkdeList(LinkedList版)
 */
import com.sun.javafx.sg.prism.web.NGWebView;
import java.util.LinkedList;
public class LinkedListTest1 {

    public static void main(String[] args) {
        //实例化一个LinkedList容器   引用类型也为LinkedList
        LinkedList<String> linkedList1= new LinkedList<>();

        //添加元素
        linkedList1.addFirst("a");
        linkedList1.addFirst("b");
        linkedList1.addFirst("c");

        for (String string:linkedList1){
            System.out.println(string);
        }
        System.out.println("--------------------");
        LinkedList<String> linkedList2= new LinkedList<>();
        linkedList2.addLast("a");
        linkedList2.addLast("b");
        linkedList2.addLast("c");

        for (String str:linkedList2){
            System.out.println(str);
        }

        //获取元素
        System.out.println("----------------------");
        String first = linkedList2.getFirst();
        System.out.println(first);

        String last = linkedList2.getLast();
        System.out.println(last);
        System.out.println("----------------------");
        //移除元素      返回被移除的值
        String s = linkedList2.removeFirst();
        System.out.println(s+"s");
        String s1 = linkedList2.removeLast();
        System.out.println(s1+"s1");
        for (String str:linkedList2){
            System.out.println(str);
        }

        System.out.println("----------*-----------");
        System.out.println(linkedList2.pop());//返回的是删除的元素
        System.out.println("----------*-----------");
        linkedList2.push("guojiaqi");
        for (String str:linkedList2){
            System.out.println(str);
        }

    }
}
