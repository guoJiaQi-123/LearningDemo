package com.tyut._03hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OldGj 2024/03/22
 * @version v1.0
 * @apiNote 454. 四数相加 II
 */
public class E07fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }
        return res;
    }


}
