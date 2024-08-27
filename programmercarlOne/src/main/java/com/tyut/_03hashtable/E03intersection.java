package com.tyut._03hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author OldGj 2024/03/21
 * @version v1.0
 * @apiNote 349. 两个数组的交集
 */
public class E03intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && !list.contains(i)) {
                list.add(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
