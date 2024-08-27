package com.tyut._04string;

/**
 * @author OldGj 2024/03/29
 * @version v1.0
 * @apiNote 459. 重复的子字符串
 */
public class E07repeatedSubstringPattern {

    // 移动匹配
    /*
        判断字符串s是否由重复子串组成，只要两个s拼接在一起，里面还出现一个s的话，就说明是由重复子串组成。
        当然，我们在判断 s + s 拼接的字符串里是否出现一个s的的时候，要刨除 s + s 的首字符和尾字符，
        这样避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s。
     */
    public boolean repeatedSubstringPattern2(String s) {
        String t = s + s;
        String substring = t.substring(1, t.length() - 1); // 掐头去尾
        return substring.contains(s);
    }


    // KMP 算法
    public boolean repeatedSubstringPattern3(String s) {
        int len = s.length();
        // 根据字符串s计算得出前缀表数组next
        int[] next = getNext(s);
        // 前缀表数组中最后一位即为对整个字符串的最长相等前缀数
        int max = next[len - 1];
        // 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，
        // 也就是一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        return max != 0 && len % (len - max) == 0;
    }

    private int[] getNext(String s) {
        char[] array = s.toCharArray();
        int[] next = new int[s.length()];
        int i = 1; // 后缀
        int j = 0; // 前缀
        while (i < s.length()) {
            // 判断前后缀的匹配情况  成功 / 失败（失败时又分两种情况 j==0 / j!=0）
            if (array[i] == array[j]) { // 前后缀匹配成功
                j++; // j 先 ++ 再更新next数组
                next[i] = j;
                i++;
            } else if (j == 0) {
                i++;
            } else { // 匹配失败且j!=0
                j = next[j - 1];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        E07repeatedSubstringPattern e07repeatedSubstringPattern = new E07repeatedSubstringPattern();
        boolean b = e07repeatedSubstringPattern.repeatedSubstringPattern3("abac");
        System.out.println(b);
    }
}
