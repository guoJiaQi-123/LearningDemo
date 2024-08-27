package com.tyut._03hashtable;


import java.util.*;

/**
 * @author OldGj 2024/03/21
 * @version v1.0
 * @apiNote 350. 两个数组的交集 II
 */
public class E04intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && !res.contains(i)) {
                for (int j = 0; j < map.get(i); j++) {
                    res.add(i);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        E04intersect e04intersect = new E04intersect();
        int[] intersect = e04intersect.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(intersect));
    }
}
