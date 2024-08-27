package com.feishu._03hashtable;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/8/1
 * @apiNote 349. 两个数组的交集
 */
public class E02intersection {

    /*
        使用map先收集nums1数组中各个值出现的次数，然后遍历nums2时，将同样出现的值加入一个链表集合
        最终对链表进行去重，转换为int数组返回【使用stream API】
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
        }
        // 将重复出现的元素加入到reList集合，可能同一个值在nums2中出现多次，则加入了多个，后序需要去重，或者直接使用Set
        List<Integer> reList = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                reList.add(i);
            }
        }
        // 使用流式API将set类型转换为int数组类型并返回【因为前面使用的是hashMap，因此需要注意在Stream API去重】
        return reList.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

    /*
        使用hashSet进行去重
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> reSet = new HashSet<>();
        for (int i : nums1) {
            set.add(i); // 将nums1中的元素加入到hashSet中【去重】
        }
        for (int i : nums2) {
            if (set.contains(i)) { // 判断nums2中的元素是否在nums1中也出现过
                reSet.add(i);  // 如果一个元素即出现在nums1中又出现在nums2中，则加入到reSet集合，本质也是hashSet
            }
        }
        // 使用流式API将set类型转换为int数组类型并返回
        return reSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
