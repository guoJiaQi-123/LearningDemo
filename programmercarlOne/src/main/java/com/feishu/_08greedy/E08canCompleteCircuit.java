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

    public static void main(String[] args) {
        int i = new E08canCompleteCircuit().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }
}
