package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/7
 * @apiNote 93. 复原 IP 地址
 */
public class E07restoreIpAddresses {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; // 算是剪枝了
        backTrack(s, 0, 0);
        return result;
    }

    // startIndex：搜索的起始位置， pointNum：添加逗点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        //  [startIndex, i] 这个区间就是截取的子串，需要判断这个子串是否合法。
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pointNum++;
                backTrack(s, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为 i+2
                pointNum--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    /*
        段位以0为开头的数字不合法
        段位里有非正整数字符不合法
        段位如果大于255了不合法
     */
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }


    // 2024/09/21
    static class Solution {
        LinkedList<String> res = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s.length() > 12) {
                return res;
            }
            backTrack(s, 0, 0);
            return res;
        }

        private void backTrack(String s, int startIndex, int pointNum) {
            if (pointNum == 3) {
                if (isValid(s, startIndex, s.length() - 1)) {
                    res.add(s);
                }
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isValid(s, startIndex, i)) { // [startIndex,i]就是切割到的子串，判断其是否合法即可
                    s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                    pointNum++;
                    backTrack(s, i + 2, pointNum);
                    pointNum--;
                    s = s.substring(0, i + 1) + s.substring(i + 2);
                } else {
                    break;
                }
            }
        }

        /**
         *  验证当前子串是否符合下面三个条件
         *  1.子串的第一个字符不为0
         *  2.子串总数不大于255
         *  3.子串为正整数
         */
        private boolean isValid(String s, int start, int end) {
            if (start > end) {
                return false;
            }
            if (s.charAt(start) == '0' && start != end) {
                return false;
            }
            int num = 0;
            for (int i = start; i <= end; i++) {
                num = num * 10 + s.charAt(i) - '0';
                if (num > 255) {
                    return false;
                }
            }
            return true;
        }
    }
}
