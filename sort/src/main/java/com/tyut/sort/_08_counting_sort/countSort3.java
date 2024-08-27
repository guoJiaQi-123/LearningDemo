package com.tyut.sort._08_counting_sort;

import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.function.IntPredicate;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 计数排序
 */
public class countSort3 {

    public static void main(String[] args) {
        int[] ints = new int[]{5, 4, 3, 2, 1};
        countSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void countSort(int[] nums) {
        // 1. 统计数组最大元素 max
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        // 2. 统计各数字的出现次数
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        // 3. 求 counter 的前缀和，将“出现次数”转换为“尾索引”
        int[] prefix = new int[count.length];
        prefix[0] = count[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = count[i] + prefix[i - 1];
        }
        // 4. 倒序遍历 nums ，将各元素填入结果数组 res
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            res[prefix[num] - 1] = num;
            prefix[num]--;
        }
        // 使用结果数组 res 覆盖原数组 nums
        System.arraycopy(res, 0, nums, 0, nums.length);
    }


}
