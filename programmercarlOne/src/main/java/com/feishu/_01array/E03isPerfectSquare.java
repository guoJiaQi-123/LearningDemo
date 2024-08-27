package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/10
 * @apiNote 367. 有效的完全平方数
 */
public class E03isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            long mm = (long) mid * mid; // 防止num过大，导致mid*mid越界，开long型
            // 如果mm == num，说明是有效完全平方数，直接返回true
            if (mm == num) {
                return true;
            } else if (mm < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
