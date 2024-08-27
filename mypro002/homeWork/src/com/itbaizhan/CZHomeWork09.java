package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/12
 *本类内容：
 */



import java.util.Scanner;

public class CZHomeWork09 {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String s =scanner.nextLine();
        char chars[] =s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(chars[i]>=97&&chars[i]<=122){
                chars[i]-=32;
            }else if(chars[i]>=65&&chars[i]<=90){
                chars[i]+=32;
            }
        }
        for (char str:chars){
            System.out.print(str);
        }


    }
}
