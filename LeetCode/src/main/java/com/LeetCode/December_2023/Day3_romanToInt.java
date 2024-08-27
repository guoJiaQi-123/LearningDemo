package com.LeetCode.December_2023;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 定义一个Map，用来存储字符和整数的映射关系
    static Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    // 定义一个函数，用来将罗马数字转换为整数
    public static int romanToInt(String s) {
        // 定义一个变量ans，用来存储转换后的整数
        int ans = 0;
        // 获取罗马数字的长度
        int n = s.length();
        // 遍历罗马数字中的每一个字符
        for (int i = 0; i < n; ++i) {
            // 获取每一个字符对应的整数
            int value = symbolValues.get(s.charAt(i));
            // 如果当前字符的整数小于下一个字符的整数，则减去当前字符的整数
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            // 否则，加上当前字符的整数
            } else {
                ans += value;
            }
        }
        // 返回转换后的整数
        return ans;
    }
}

public class Day3_romanToInt {

    //模拟
    public static int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c == 'I'){
                if(i==len-1 ){
                    result += 1;
                }
                else if( s.charAt(i+1)== 'V' || s.charAt(i+1)== 'X'){
                    result -= 1;
                }else{
                    result += 1;
                }
            }else if(c == 'V'){
                result += 5;
            }else if(c == 'X'){
                if(i==len-1 ){
                    result += 10;
                }
                else if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'){
                    result -= 10;
                }else{
                    result += 10;
                }
            }else if(c == 'L'){
                result += 50;
            }else if(c == 'C'){
                if(i==len-1 ){
                    result += 100;
                }
                else if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M'){
                    result -= 100;
                } else{
                    result += 100;
                }
            }else if(c == 'D'){
                result += 500;
            }else{
                result += 1000;
            }
        }
        return result;
    }


    //模拟  switch语法
        public static int romanToInt2(String s) {
            int len = s.length();
            int result = 0;
            for(int i=0;i<len;i++){
                switch (s.charAt(i)){
                    case 'I':
                        if(i==len-1 ){
                            result += 1;
                        }
                        else if( s.charAt(i+1)== 'V' || s.charAt(i+1)== 'X'){
                            result -= 1;
                        }else{
                            result += 1;
                        }
                    case 'V':result += 5;
                    case 'X':
                        if(i==len-1 ){
                            result += 10;
                        }
                        else if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'){
                            result -= 10;
                        }else{
                            result += 10;
                        }
                    case 'L':result += 50;
                    case 'C':
                        if(i==len-1 ){
                            result += 100;
                        }
                        else if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M'){
                            result -= 100;
                        } else{
                            result += 100;
                        }
                    case 'D': result += 500;
                    default:result += 1000;
                }
            }
            return result;
        }


}
