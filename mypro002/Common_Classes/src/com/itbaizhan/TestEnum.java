package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/05
 *本类内容：
 */

import java.util.Random;

public class TestEnum {

    public static void main(String[] args) {

        // 枚举遍历
        for (Season season:Season.values()){
            System.out.println(season);
        }

        // switch语句中使用枚举
        int a= new Random().nextInt(4);   //生成0,1,2,3随机数
        switch (Season.values()[a]){
            case AUTUMN:
                System.out.println("秋天");
                break;
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case WINDER:
                System.out.println("冬天");
                break;

        }
    }
}
enum Season{             //季节
    SPRING,SUMMER,AUTUMN,WINDER
}