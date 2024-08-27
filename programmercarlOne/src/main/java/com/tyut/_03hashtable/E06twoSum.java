package com.tyut._03hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OldGj 2024/03/22
 * @version v1.0
 * @apiNote 1. 两数之和
 */
public class E06twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
