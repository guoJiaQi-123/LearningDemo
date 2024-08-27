package com.tyut.sort._10_radixsort;

import java.util.ArrayList;

/**
 * @version v1.0
 * @author OldGj 2024/4/30
 * @apiNote 基数排序
 */
public class RadixSort {


    /**
     * 基数排序
     * @param nums 待排序数组
     */
    public static void radixSort(String[] nums, int length) {
        // 1. 准备桶
        ArrayList<String>[] buckets = new ArrayList[128];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = length - 1; i >= 0; i--) {
            // 2. 从个位开始从后往前进行排序
            for (String s : nums) {
                buckets[s.charAt(i)].add(s);
            }
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    nums[k++] = s;
                }
                // 3. 每个桶中的元素全部加入到原始数组后，清空桶
                bucket.clear();
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"487","124","654","125","157"};
        radixSort(strings,3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
