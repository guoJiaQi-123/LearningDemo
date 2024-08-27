package com.tyut._05doublepointer;

/**
 * @author OldGj 2024/03/31
 * @version v1.0
 * @apiNote 27. 移除元素
 */
public class E01removeElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0; // 构建新数组 慢指针：指向更新 新数组下标的位置
        int fast = 0; // 遍历旧数组 快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) { // 只有不为val才使用slow构建
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
