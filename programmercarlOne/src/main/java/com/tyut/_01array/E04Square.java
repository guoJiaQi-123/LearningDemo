package com.tyut._01array;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 69. x 的平方根
 */
public class E04Square {

    public int mySqrt2(int x) {
        int i = 1;
        int j = x;
        int n = 0;
        while (i <= j) {
            int m = (i + j) >>> 1;
            int mm = m * m;
            if (mm == x) {
                return m;
            } else if (mm < x) {
                n = m;
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return n;
    }

    public int mySqrt(int x) {
        /*

            99 = 9.???

            1 * 1 = 1
            2 * 2 = 4
            3 * 3 = 9
            4 * 4 = 16
            ---
            9 * 9 = 81
            10 * 10 = 100

            二分
            i   j   n
            1   99  50
            1   49  25
            1   24  12
            1   11  6
            7   11  9
            10  11  10
         */
        int i = 1;
        int j = x;
        int n = 0;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (x / mid >= mid) {
                i = mid + 1;
                n = mid;
            } else {
                j = mid - 1;
            }
        }
        return n;
    }
}
