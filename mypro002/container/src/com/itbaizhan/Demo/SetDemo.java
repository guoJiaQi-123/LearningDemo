package com.itbaizhan.Demo;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：产生1-10之间的随机数([1,10]闭区间)，将不重复的10个随机数放到容器中。
 */

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<Integer> set =new HashSet<>();
        while (true){
            int num =(int) (Math.random()*10+1);
            set.add(num);
            if(set.size()==10){
                break;
            }

        }
        for(Integer i : set){
            System.out.println(i);
        }
    }
}
