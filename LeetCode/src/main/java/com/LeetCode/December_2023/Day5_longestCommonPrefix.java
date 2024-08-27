package com.LeetCode.December_2023;

/**
 * 横向扫描
 */
public class Day5_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        // 判断字符串数组是否为空
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 获取字符串数组的第一个字符串
        String s1 = strs[0];
        // 获取字符串数组的长度
        int count = strs.length;
        // 遍历字符串数组
        for (int i = 1; i < count; i++) {
            // 获取两个字符串的最长公共前缀
            s1 = towLongestCommon(s1, strs[i]);
            // 如果最长公共前缀为空，则跳出循环
            if (s1.isEmpty()) {
                break;
            }
        }
        // 返回最长公共前缀
        return s1;
    }

    //获取两个字符串的最长公共前缀
    private String towLongestCommon(String s1, String s2) {
        // 获取两个字符串的最小长度
        int min = Math.min(s1.length(), s2.length());
        // 定义索引
        int index = 0;
        // 遍历两个字符串
        while (index < min && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }
        // 返回两个字符串的最长公共前缀
        return s1.substring(0, index);
    }

}

class Day5_longestCommonPrefix_2 {
    public String longestCommonPrefix(String[] strs) {
        // 如果字符串数组为空或者为null，则返回空字符串
        if (strs.length == 0 || strs == null) {
            return "";
        }
        // 获取字符串数组中第一个字符串的长度
        int length = strs[0].length();
        // 获取字符串数组中字符串的数量
        int count = strs.length;
        // 遍历字符串数组中第一个字符串的每一个字符
        for (int i = 0; i < length; i++) {
            // 获取字符串数组中第一个字符串的第i个字符
            char c = strs[0].charAt(i);
            // 遍历字符串数组中剩余的字符串
            for (int j = 1; j < count; j++) {
                // 获取字符串数组中第j个字符串的第i个字符
                char c1 = strs[j].charAt(i);
                // 如果字符串数组中第j个字符串的长度小于i或者字符串数组中第j个字符串的第i个字符与第一个字符串的第i个字符不相等，则返回第一个字符串的前i个字符
                if (i == strs[j].length() || c != c1) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // 如果遍历完字符串数组中第一个字符串的所有字符，没有出现上面的情况，则返回第一个字符串
        return strs[0];

    }
}

//分治算法
class Day5_longestCommonPrefix_3 {
    public String longestCommonPrefix(String[] strs) {
        // 获取字符串数组的长度
        int len = strs.length;
        // 如果字符串数组为空或者长度为0，则返回空字符串
        if (strs == null || len == 0) {
            return "";
        } else {
            // 否则调用longestCommonPrefix方法，传入字符串数组，以及起始位置和结束位置
            return longestCommonPrefix(strs, 0, len - 1);
        }
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        // 如果起始位置等于结束位置，则返回该位置的字符串
        if (start == end) {
            return strs[start];
        }
        // 计算中间位置
        int mid = (end - start) / 2 + start;
        // 递归调用longestCommonPrefix方法，获取左边字符串的最长公共前缀
        String left = longestCommonPrefix(strs, start, mid);
        // 递归调用longestCommonPrefix方法，获取右边字符串的最长公共前缀
        String right = longestCommonPrefix(strs, mid + 1, end);
        // 返回左右字符串的最长公共前缀
        return longestCommonPrefix(left,right);
    }

    private String longestCommonPrefix(String left,String right){
        // 获取左右字符串的最小长度
        int min = Math.min(left.length(), right.length());
        // 遍历最小长度，比较左右字符串的每一个字符
        for (int i = 0; i < min; i++) {
            // 如果左右字符串的每一个字符不相等，则返回从开头到当前字符的字符串
            if(left.charAt(i)!=right.charAt(i)){
                return left.substring(0,i);
            }
        }
        // 如果左右字符串的每一个字符都相等，则返回最小长度长度的字符串
        return left.substring(0,min);
    }
}