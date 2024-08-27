package com.tyut._01array;

/**
 * @author OldGj 2024/03/13
 * @version v1.0
 * @apiNote 76. 最小覆盖子串
 */
public class E13minWindow {
    static class Result {
        int left;
        int right;

        public Result(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public String minWindow(String s, String t) {
        /*
            ADOBECODEBANC
            ABC
         */
        char[] sourceArray = s.toCharArray();
        int[] sourceCount = new int[128];
        char[] targetArray = t.toCharArray();
        int[] targetCount = new int[128];
        for (char ch : targetArray) {
            targetCount[ch]++;
        }
        // 需要满足的条件数
        int count = 0;
        for (int i : targetCount) {
            if (i > 0) {
                count++;
            }
        }
        // 已经满足的条件数
        int counted = 0;
        int left = 0;
        Result result = null;
        for (int right = 0; right < sourceArray.length; right++) {
            char rightCh = sourceArray[right];
            // 统计原始串 left~right 范围各种字符的个数
            sourceCount[rightCh]++;
            // 如果原始串中字符出现的次数等于目标串中字符出现的次数
            if (sourceCount[rightCh] == targetCount[rightCh]) {
                // 已经满足一个条件
                counted++;
            }
            // 如果已经满足条件个数等于需要满足的条件个数说明找到一个解
            while (left <= right && counted == count) { // 找到一个解
                // 找所有满足条件的解中，长度最小的
                if (result == null) {
                    result = new Result(left, right);
                } else {
                    if ((right - left) < (result.right - result.left)) {
                        result = new Result(left, right);
                    }
                }
                // 开始移动left，找长度更小的解
                char leftCh = sourceArray[left];
                sourceCount[leftCh]--;
                if (sourceCount[leftCh] < targetCount[leftCh]) {
                    counted--;
                }
                left++;
            }
        }
        return result == null ? "" : new String(sourceArray, result.left, result.right - result.left + 1);
    }

    public static void main(String[] args) {
        E13minWindow e13minWindow = new E13minWindow();
        String s = e13minWindow.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
