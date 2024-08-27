package com.tyut.sort._05_merge_sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/23
 * @apiNote 归并排序自下而上
 */
public class MergeSortDownToTop {

    public void mergeSort(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        // width 代表有序区间的宽度，取值依次为 1,2,4 ...
        for (int width = 1; width < len; width *= 2) {
            // [left,right] 分别代表合并区间的左右边界
            // 每次合并两个有序区间，因此左边界每次循环 ＋ 2 * width
            for (int left = 0; left < len; left += 2 * width) {
                //右边界为下次左边界 - 1
                int right = Math.min(len - 1, left + 2 * width - 1);
                //中间值mid为左边界 + 一个宽度width - 1
                int mid = Math.min(len - 1, left + width - 1);
                merge(nums, left, mid, mid + 1, right, arr);
            }
            System.arraycopy(arr, 0, nums, 0, len);
        }
    }

    /**
     * 合并有序数组
     *
     * @param nums 原始数组
     * @param i  iEnd 第一个有序范围
     * @param j  jEnd 第二个有序范围
     * @param arr 临时数组
     */
    private void merge(int[] nums, int i, int iEnd, int j, int jEnd, int[] arr) {
        // 定义一个k操作临时数组
        int k = i;
        //如果i和j都在有效范围内
        while (i <= iEnd && j <= jEnd) {
            //比较i和j处索引的数组的值，并把较小的值加入到临时数组a2中
            if (nums[i] < nums[j]) {
                arr[k] = nums[i];
                i++;
            } else {
                arr[k] = nums[j];
                j++;
            }
            //更新操作临时数组的指针
            k++;
        }
        // 当i > iEnd说明第一个有序范围内的元素已经全部迭代，将第二范围内没有被迭代的元素拷贝到arr数组即可
        if (i > iEnd) {
            System.arraycopy(nums, j, arr, k, jEnd - j + 1);
        }
        // 当j > jEnd说明第二个有序范围内的元素已经全部迭代，将第一范围内没有被迭代的元素拷贝到arr数组即可
        if (j > jEnd) {
            System.arraycopy(nums, i, arr, k, iEnd - i + 1);
        }
    }
}
