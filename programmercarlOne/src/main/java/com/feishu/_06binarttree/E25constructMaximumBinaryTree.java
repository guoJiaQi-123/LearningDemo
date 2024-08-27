package com.feishu._06binarttree;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/8/20
 * @apiNote 654. 最大二叉树
 */
public class E25constructMaximumBinaryTree {
    /*
        递归参数只有一个数组，没有边界，调用递归时需要创建新的数组
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 递归的终止条件
        if (nums.length == 0) {
            return null;
        }
        int max = -1; // 最大值
        int index = 0; // 最大值索引
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        // 需要创建新的数组
        int[] leftArr = Arrays.copyOfRange(nums, 0, index);
        int[] rightArr = Arrays.copyOfRange(nums, index + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftArr);
        root.right = constructMaximumBinaryTree(rightArr);
        return root;
    }

    /*
        递归参数不仅有数组，而且有数组边界，调用递归时只需要指定边界即可，不需要创建新的数组
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return doBuildTree(nums, 0, nums.length);
    }

    private TreeNode doBuildTree(int[] nums, int left, int right) {
        // 没有元素了
        if (right - left < 1) {
            return null;
        }
        // 只剩下一个元素了
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }
        // 假设最左侧的元素最大
        int maxIndex = left; // 最大值索引
        int max = nums[maxIndex]; // 最大值
        // 在[left,right]区间内找最大元素，并且记录其索引值
        for (int i = left + 1; i < right; i++) { // 左闭右开
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = doBuildTree(nums, left, maxIndex); // 递归创建左子树
        root.right = doBuildTree(nums, maxIndex + 1, right); // 递归创建右子树
        return root;
    }
}
