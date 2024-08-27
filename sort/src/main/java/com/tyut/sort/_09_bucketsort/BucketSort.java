package com.tyut.sort._09_bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 桶排序
 */
public class BucketSort {


    public static void main(String[] args) {
        int[] ints = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        bucketSort(ints, 3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 桶排序
     * @param nums 待排序数组
     * @param range 每个桶中数据的最大范围
     */
    public static void bucketSort(int[] nums, int range) {
        // 1. 先求最大值和最小值（高效确定桶的个数）
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        // 2. 初始化桶的个数   桶的数量为(max-min)/range + 1
        int bucket_count = (max - min) / range + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucket_count; i++) {
            buckets.add(new ArrayList<>());
        }
        // 遍历输入的数据 放入对应的桶中
        for (int num : nums) {
            int idx = (num - min) / range;
            buckets.get(idx).add(num);
        }
        int k = 0;
        for (List<Integer> bucket : buckets) {
            int[] array = bucket.stream().mapToInt(Integer::intValue).toArray();
            // 3.排序桶内元素
            Arrays.sort(array);
            for (int a : array) {
                nums[k++] = a;
            }
        }
    }

}
