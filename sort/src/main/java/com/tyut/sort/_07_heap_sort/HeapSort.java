package com.tyut.sort._07_heap_sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/25
 * @apiNote 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = new int[]{9,5,4,78,1,2,35};
        heapSort.heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public void heapSort(int[] nums) {
        // 1.建立大顶堆
        toMaxHeap(nums, nums.length);
        // 2.每次将大顶堆的堆顶元素和最后一个元素交换
        // 交换以后可能破坏了大顶堆的特性，需要重新对堆顶元素执行一次下潜操作
        for (int right = nums.length - 1; right > 0; right--) {
            swap(nums, 0, right); // 交换
            down(nums, 0, right); // 下潜
        }
    }

    private void toMaxHeap(int[] nums, int length) {
        // 找到最后一个非叶子节点，对每个非叶子节点执行一次下潜操作
        for (int i = (length >>> 1) - 1; i >= 0; i--) {
            // 下潜操作
            down(nums, i, length);
        }
    }

    private void down(int[] nums, int parent, int length) {
        while (true) {
            // 找到父节点的左孩子和右孩子
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < length && nums[left] > nums[max]) {
                max = left;
            }
            if (right < length && nums[right] > nums[max]) {
                max = right;
            }
            if (max == parent) {
                break;
            }
            swap(nums, max, parent);
            parent = max;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
