package com.feishu._08greedy;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/9/27
 * @apiNote 53. 最大子数组和
 */
public class E03maxSubArray {
    /*
        核心思想就是，累加nums数组，但是如果累加和小于0，则从下一位重新开始累加
        （因为只要是小于0，则对后面就只起到拉小值的副作用）
        在累加过程中记录之前的最大累加和
     */
    public int maxSubArray(int[] nums) {
        // 校验
        if (nums.length == 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE; // 将result初始化为最小值
        int count = 0;
        for (int num : nums) {
            count += num;
            result = Math.max(result, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return result;
    }
}
