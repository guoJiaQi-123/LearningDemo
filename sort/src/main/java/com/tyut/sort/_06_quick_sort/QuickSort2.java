package com.tyut.sort._06_quick_sort;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote 快速排序双边
 */
public class QuickSort2 {
    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        int[] ints = new int[]{9, 5, 7, 8, 4, 1, 2, 3, 6};
        quickSort2.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }

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

    private int partition(int[] nums, int left, int right) {
        int mid = (left + right) >>> 1;
        int pvIndex = selectIndex(nums, left, mid, right);
        swap(nums, left, pvIndex);
        int pv = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[j] > pv) {
                j--;
            }
            while (i <= j && nums[i] < pv) {
                i++;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, left,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int selectIndex(int[] nums, int left, int mid, int right) {
        int l = nums[left];
        int m = nums[mid];
        int r = nums[right];
        if (m >= l && l <= r) {
            return left;
        }
        if (m >= r && r <= l) {
            return right;
        }
        return mid;
    }
}
