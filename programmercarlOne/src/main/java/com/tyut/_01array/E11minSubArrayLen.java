package com.tyut._01array;

/**
 * @author OldGj 2024/03/12
 * @version v1.0
 * @apiNote 209. 长度最小的子数组
 */
public class E11minSubArrayLen {

    // 暴力 已经超时
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        int x = 1;
        for (int i = 0; i < nums.length; i++) {
            if (x != 1 && res < target) {
                break;
            }
            x = 2;
            res = 0;
            for (int j = i; j < nums.length; j++) {
                if ((j - i + 1) > min) {
                    break;
                }
                res += nums[j];
                if (res >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 滑动窗口
    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0;
        int left = 0; // 左窗口
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) { // 右窗口
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1); // 记录窗口的最小值
                sum -= nums[left]; // 减去左窗口，收缩窗口
                left++;
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
        /*
                2   3   1   2   4   3
                x
                i
         */

    public static void main(String[] args) {
        E11minSubArrayLen e11minSubArrayLen = new E11minSubArrayLen();
        int i = e11minSubArrayLen.minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }

}
