package com.algorithm.sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/08
 * @apiNote <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F-quick-sort">
 *     6.快速排序❤
 *     </a>
 */
public class E06QuickSort {

    public static void main(String[] args) {
        E06QuickSort e06QuickSort = new E06QuickSort();
        int[] ints = {5, 4, 3, 2, 1};
        e06QuickSort.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    // 单边循环快排
    public void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 分区
        int p = partition(nums, left, right);
        doQuickSort(nums, left, p - 1);
        doQuickSort(nums, p + 1, right);
    }

    /**
     * <h3>单边循环快排（lomuto 洛穆托分区方案）</h3>
     * <p>核心思想：每轮找到一个基准点元素，把比它小的放到它左边，比它大的放到它右边，这称为分区</p>
     * <ol>
     * <li>选择最右元素作为基准点元素</li>
     * <li>j 找比基准点小的，i 找比基准点大的，一旦找到，二者进行交换</li>
     * <ul>
     * <li>交换时机：j 找到小的，且与 i 不相等</li>
     * <li>i 找到 >= 基准点元素后，不应自增</li>
     * </ul>
     * <li>最后基准点与 i 交换，i 即为基准点最终索引</li>
     * </ol>
     */
    private int partition(int[] nums, int left, int right) {
        int pv = nums[right]; // 基准元素
        int i = left; // 找比基准点大的值，如果找到大于等于基准点的值，不在移动
        int j = left; // 找比基准点小的值
        while (j < right) {
            if (nums[j] < pv) {
                if (j != i) {
                    swap(nums, i, j);
                }
                // 只有找到的值比基准点小,i才++，如果大于基准点的值,i不变,j++
                // 等到下次找到比基准点小的值,i和j不相等，进行交换
                i++;
            }
            j++;
        }
        swap(nums, right, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
