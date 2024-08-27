package com.feishu._03hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/8/2
 * @apiNote 18. 四数之和
 */
public class E08fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        // 第一个指针i，用于指向a数，范围[0 ~ len-4]
        for (int i = 0; i < len - 3; i++) {
            // 剪枝，如果四个连续的数相加大于target，因为数组有序，后序也不会再出现四数和等于0的情况了，直接跳出循环
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 剪枝，如果当前第一个指针的值加上数组中后面三个最大的值任然小于target，则跳出当前循环，使指针向右继续移动
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            // 对a进行去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                // 剪枝，同上
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 剪枝，同上
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                // 对b数进行去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--; // sum大于target，使right--
                    } else if (sum < target) {
                        left++; // sum小于target，使left++
                    } else {
                        // 找到四个数之和等于target，加入结果集合
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对c数和d数进行去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        // 去重后还需要缩小指针范围
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
