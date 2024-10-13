package com.feishu._08greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @version v1.0
 * @author OldGj 2024/10/9
 * @apiNote 1005. K 次取反后最大化的数组和
 */
public class E07largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int K) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = Arrays.stream(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && K > 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完

        if (K % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();

    }
}
