package com.feishu._03hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/8/2
 * @apiNote 454. 四数相加 II
 */
public class E05fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 使用map集合保存前两个数组的两数之和  {key:两数之和，value:出现的次数}
        Map<Integer, Integer> map = new HashMap<>();
        // 将前两个数组的两数之和加入map集合中
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 定义一个res用于记录四数之和出现的次数
        int res = 0;
        // 遍历后两个数组并判断之前保存的map集合中是否存在-(i + j)，如果存在，则可以组成一个四数之和为0
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-(i + j), 0);
            }
        }
        return res;
    }
}
