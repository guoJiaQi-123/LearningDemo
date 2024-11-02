package com.feishu._08greedy;

/**
 * @version v1.0
 * @author OldGj 2024/11/2
 * @apiNote 860. 柠檬水找零
 */
public class E10lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else { // 美元10只能给账单20找零，而美元5可以给账单10和账单20找零，美元5更万能！
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }
}
