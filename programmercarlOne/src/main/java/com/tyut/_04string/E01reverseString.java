package com.tyut._04string;

/**
 * @author OldGj 2024/03/26
 * @version v1.0
 * @apiNote 344. 反转字符串
 */
public class E01reverseString {

    // 双指针
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        E01reverseString e01reverseString = new E01reverseString();
        e01reverseString.reverseString(new char[]{'h','e','l','l','o'});

    }
}
