package com.tyut._05doublepointer;

/**
 * @author OldGj 2024/03/31
 * @version v1.0
 * @apiNote 344. 反转字符串
 */
public class E02reverseString {
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

    public void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            s[left]^=s[right];
            s[right]^=s[left];
            s[left]^=s[right];
            left++;
            right--;
        }

    }
}
