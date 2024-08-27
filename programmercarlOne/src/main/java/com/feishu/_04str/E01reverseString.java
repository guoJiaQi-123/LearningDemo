package com.feishu._04str;

/**
 * @version v1.0
 * @author OldGj 2024/8/5
 * @apiNote 344. 反转字符串
 */
public class E01reverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] s, int left, int right) {
        char t = s[left];
        s[left] = s[right];
        s[right] = t;
    }
}
