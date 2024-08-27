package com.feishu._03hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/8/1
 * @apiNote 1. 两数之和
 */
public class E04twoSum {
    /*
        使用hashMap存放nums中已经遍历过的值【做个记录】
        在后序遍历中，判断是否存在已经遍历过的值和正在遍历的值之和恰好等于target
     */
    public int[] twoSum(int[] nums, int target) {
        // 定义一个map集合存放nums数组中的元素及其索引[ key - 元素，value - 索引]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int prevNum = target - nums[i]; // 如果数组中之前出现过prevNum，则说明两数和可以等于target
            if (map.containsKey(prevNum)) {
                // 如果之前存在过，则返回索引
                return new int[]{map.get(prevNum), i};
            } else {
                // 否则将当前的值和索引作为map的键和值加入到map中
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
