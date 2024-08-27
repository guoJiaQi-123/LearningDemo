package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/10
 * @apiNote 69. x 的平方根
 */
public class E02mySqrt {

    /*
        开long长整形避免越界问题
     */
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int candidate = 0; // 候选值
        while (left <= right) {
            int m = left + ((right - left) >>> 1); // 二分，防止越界
            long mm = (long) m * m; // 如果 x 值很大，此时的 m 也很大，那么就会导致m的平方越界，因此此处开long
            if (mm < x) { // 当m的平方小于x时，需要记录候选值，比如求99的平方根，二分到9时，81小于99，此时需要记录9，然后再去算10的平方
                left = m + 1;
                candidate = m;
            } else if (mm > x) {
                right = m - 1;
            } else {
                return m; // 如果m的平方直接等于x，则直接返回m
            }
        }
        return candidate; // 循环结束，返回最后一次赋值的候选值
    }

    /*
           使用除法巧妙的解决越界问题
     */
    public int mySqrt2(int x) {
        int left = 1;
        int right = x;
        int candidate = 0; // 候选值
        while (left <= right) {
            int m = left + ((right - left) >>> 1); // 二分，防止越界
            // m < x / m  =>  m的平方 < x
            if (m < x / m) { // 当m的平方小于x时，需要记录候选值，比如求99的平方根，二分到9时，81小于99，此时需要记录9，然后再去算10的平方
                left = m + 1;
                candidate = m; // 记录候选值
            } else if (m > x / m) {
                right = m - 1;
            } else {
                return m; // 如果m的平方直接等于x，则直接返回m
            }
        }
        return candidate; // 循环结束，返回最后一次赋值的候选值
    }
}
