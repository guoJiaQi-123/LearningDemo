package com.tyut._04string;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote 541. 反转字符串 II
 */
public class E02reverseStr {

    // 模拟
    public String reverseStr(String s, int k) {
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (s.length() - i < k) {// 如果剩余字符少于 k 个，则将剩余字符全部反转。
                s = reverse(s, i, s.length() - 1);
                break;
            }
            //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            if (s.length() - i < 2 * k || s.length() - i > k) {
                s = reverse(s, i, i + k - 1);
            }
        }
        return s;
    }

    /**
     * 交换 s 在 i 和 j 区间中的字符串
     */
    private String reverse(String s, int i, int j) {
        char[] ss = s.toCharArray();
        while (i < j) {
            char temp = ss[i];
            ss[i] = ss[j];
            ss[j] = temp;
            i++;
            j--;
        }
        return new String(ss);
    }
}
