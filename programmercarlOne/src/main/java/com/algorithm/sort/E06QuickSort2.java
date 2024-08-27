package com.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @version v1.0
 * @author OldGj 2024/04/08
 * @apiNote <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F-quick-sort">
 *     6.快速排序❤
 *     </a>
 */
public class E06QuickSort2 {

    public void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        doQuickSort(nums, left, p - 1);
        doQuickSort(nums, p + 1, right);
    }

    /**
     * <h3>双边循环快排</h3>
     * <ol>
     * <li>选择最左元素作为基准点元素</li>
     * <li>j 指针负责从右向左找比基准点小或等的元素，i 指针负责从左向右找比基准点大的元素，一旦找到二者交换，直至 i，j 相交</li>
     * <li>最后基准点与 i（此时 i 与 j 相等）交换，i 即为分区位置</li>
     * </ol>
     */
    private int partition(int[] nums, int left, int right) {
        /***************************随机元素作为基准点***************************/
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums,index,left);
        /***************************随机元素作为基准点***************************/
        int pv = nums[left]; // 选择最左侧元素作为基准点
        int i = left; // i 指针从左到右找大于基准点的值
        int j = right; // j 指针从右到左找小于基准点的值
        while (i < j) {
            // 1. j 从右向左找小(等)的
            while (i < j && nums[j] > pv) {
                j--;
            }
            // 2. i 从左向右找大的
            while (i < j && nums[i] <= pv) {
                i++;
            }
            // 3. 交换位置
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = {1, 23, 4, 0, 3, 3, 2, 9, 7, 6};
        E06QuickSort2 e06QuickSort2 = new E06QuickSort2();
        e06QuickSort2.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
