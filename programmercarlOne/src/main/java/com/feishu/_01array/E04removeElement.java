package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/11
 * @apiNote 27. 移除元素
 */
public class E04removeElement {

    /*
        快慢指针：快指针负责查找符合条件的新数组中的元素，这道题就是符合不等于val值的元素
                 慢指针负责将快指针找到的符合条件的元素构建为一个新数组
     */
    public int removeElement(int[] nums, int val) {
        int s = 0; // 慢指针，负责构建新数组
        // 快指针，负责查找新数组中的元素
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != val) { // 如果快指针找到符合条件的元素
                nums[s] = nums[f]; // 赋值给慢指针指向的位置
                s++; // 移动慢指针
            }
        }
        return s;
    }

    /*
        暴力：两层for循环，一个for循环遍历数组元素 ，第二个for循环更新数组。
     */
    public int removeElement2(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) { // 将后面的所有元素向前移动一步
                    nums[j - 1] = nums[j];
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--;
            }
        }
        return size;
    }


}
