package com.itbaizhan;
//测试数组的遍历
public class Array02 {

    public static void main(String[] args) {
        String cities[]={"北京","上海","广州","深圳"};

        for (int i =0;i<cities.length;i++){
            System.out.println(cities[i]);
        }

        System.out.println("********************");
        for(String s:cities){
            System.out.println(s);
        }

    }
}
