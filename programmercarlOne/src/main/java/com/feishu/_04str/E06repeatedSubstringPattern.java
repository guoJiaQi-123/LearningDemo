package com.feishu._04str;

/**
 * @version v1.0
 * @author OldGj 2024/8/7
 * @apiNote 459. 重复的子字符串
 */
public class E06repeatedSubstringPattern {
    // 移动匹配
    /*
        判断字符串s是否由重复子串组成，只要两个s拼接在一起，里面还出现一个s的话，就说明是由重复子串组成。
        当然，我们在判断 s + s 拼接的字符串里是否出现一个s的的时候，要刨除 s + s 的首字符和尾字符，
        这样避免在s+s中搜索出原来的s，我们要搜索的是中间拼接出来的s。
     */
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        String substring = t.substring(1, t.length() - 1); // 掐头去尾
        return substring.contains(s);
    }

    public boolean repeatedSubstringPattern_kmp(String s) {
        int[] next = getNext(s);
        int len = s.length();
        int maxLen = next[len - 1]; // 整个字符串的最长相等前后缀
        return maxLen != 0 && len % (len - maxLen) == 0;
    }

    private int[] getNext(String s) {
        char[] pattern = s.toCharArray();
        int[] next = new int[s.length()];
        int i = 1;
        int j = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                j++;
                next[i] = j;
                i++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
        }
        return next;
    }
}
