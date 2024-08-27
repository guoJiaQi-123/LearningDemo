package com.tyut._01array;


/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 367. 有效的完全平方数
 */
public class E05isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        /*
            99

            1   99  50
            1   49  25
            1   24  12
            1   11  6
            7   11  9
            10  11  10
         */
        /*

         */
        long i = 1;
        long j = num;
        while (i <= j) {
            long m = (i + j) >>> 1;
            long mm = m * m;
            if (mm == num) {
                return true;
            } else if (mm < num) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        E05isPerfectSquare e05isPerfectSquare = new E05isPerfectSquare();
        System.out.println(e05isPerfectSquare.isPerfectSquare(5));
    }
}
