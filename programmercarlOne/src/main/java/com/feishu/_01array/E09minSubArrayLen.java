package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/15
 * @apiNote 209. 长度最小的子数组
 */
public class E09minSubArrayLen {

    /*
        暴力
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
            sum = 0; // 每次固定序列第一个数后，将sum置0
            for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= target) { // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; // 取子序列的长度
                    res = Math.min(res, subLength);
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /*
        滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0; // 滑动窗口数值之和
        int subLength = 0; // 滑动窗口的长度
        int i = 0;// 滑动窗口的起始位置
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j]; // 窗口的终止位置右移
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= target) {
                subLength = j - i + 1; // 取子序列的长度【滑动窗口的长度】
                res = Math.min(subLength, res);
                sum -= nums[i++]; // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
