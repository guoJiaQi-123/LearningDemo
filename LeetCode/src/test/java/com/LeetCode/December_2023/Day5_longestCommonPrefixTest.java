package com.LeetCode.December_2023;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5_longestCommonPrefixTest {

    @Test
    @DisplayName("横向扫描")
    void longestCommonPrefix() {
        String[] s = new String[]{"flower","flow","flight"};
        Day5_longestCommonPrefix day5LongestCommonPrefix =new Day5_longestCommonPrefix();
        String s1 = day5LongestCommonPrefix.longestCommonPrefix(s);
        System.out.println(s1);
    }

    @Test
    @DisplayName("纵向扫描")
    void longestCommonPrefix2() {
        String[] s = new String[]{"fhjkf","fasda","flight"};
        Day5_longestCommonPrefix_2 day5LongestCommonPrefix =new Day5_longestCommonPrefix_2();
        String s1 = day5LongestCommonPrefix.longestCommonPrefix(s);
        System.out.println(s1);
    }

    @Test
    @DisplayName("substring为左闭右开")
    void test(){
        String s = "123456";
        String substring = s.substring(0, 2);
        System.out.println(substring);
    }

    @Test
    @DisplayName("分治算法")
    void longestCommonPrefix3(){
        String[] s = new String[]{"flower","flow","flight"};
        Day5_longestCommonPrefix_3 day5LongestCommonPrefix = new Day5_longestCommonPrefix_3();
        String s1 = day5LongestCommonPrefix.longestCommonPrefix(s);
        System.out.println(s1);
    }
}