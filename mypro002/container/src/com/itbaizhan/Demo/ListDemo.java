package com.itbaizhan.Demo;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：单例集合使用案例
需求：
产生1-10之间的随机数([1,10]闭区间)，将不重复的10个随机数放到容器中。

 */

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>();
        while (true){
            int num =(int) (Math.random()*10+1);

            if(!list.contains(num)){//如果这个数在容器中不存在，则将其添加到容器中
                list.add(num);
            }

            if(list.size()==10){//如果容器中元素数量等于十的话，跳出循环
                break;
            }
        }

        for(Integer i :list){
            System.out.println(i);
        }

    }
}
