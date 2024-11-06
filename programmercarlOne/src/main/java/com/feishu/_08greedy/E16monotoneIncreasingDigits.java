package com.feishu._08greedy;

/**
 * @version v1.0
 * @author OldGj 2024/11/6
 * @apiNote 738. 单调递增的数字
 */
public class E16monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int flag = s.length(); // 记录从哪个位置开始后面的数字全为9
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--; // 一旦当前数字减小
                flag = i + 1; // 当前数字后面就全部为9，使用一个flag变量记录这个位置
            }
        }
        for (int i = flag; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
