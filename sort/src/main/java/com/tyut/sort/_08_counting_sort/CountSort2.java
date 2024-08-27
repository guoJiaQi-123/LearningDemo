package com.tyut.sort._08_counting_sort;


import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 计数排序（可处理负数）
 */
public class CountSort2 {

    public static void main(String[] args) {
        int[] ints = {-1, 8, 5, -7, -6, -9, 4, 58};
        countSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void countSort(int[] nums) {
        // 找到最大值和最小值
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 把最小值映射到nums[0]处
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                nums[k++] = i + min;
                count[i]--;
            }
        }
    }

}
