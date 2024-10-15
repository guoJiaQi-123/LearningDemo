package com.feishu._08greedy;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/10/11
 * @apiNote 134. 加油站
 */
public class E08canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }

        // 如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
        if (sum < 0) return -1;
        // rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
        if (min >= 0) return 0;
        // 如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点。
        for (int i = gas.length - 1; i > 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) return i;
        }

        return -1;
    }

    static class Solution {
        /*
            局部最优：当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行。
            全局最优：找到可以跑一圈的起始位置。
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curSum = 0;
            int totalSum = 0;
            int index = 0;
            for (int i = 0; i < gas.length; i++) {
                // 一旦curSum小于零，说明[0, i]区间都不能作为起始位置，因为这个区间选择任何一个位置作为起点，到i这里都会断油
                curSum += gas[i] - cost[i]; // 每个加油站的剩余量的累加
                totalSum += gas[i] - cost[i];
                if (curSum < 0) {
                    index = i + 1;
                    curSum = 0;
                }
            }
            if (totalSum < 0) return -1; // 总加油量小于总油耗，一定跑不完
            return index;

        }
    }

    public static void main(String[] args) {

    }
}
