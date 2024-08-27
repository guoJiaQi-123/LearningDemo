package com.tyut._07binarytree;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/6/4
 * @apiNote 654. 最大二叉树
 */
public class E26constructMaximumBinaryTree {
    //方法一：分割数组需要定义新的数组，效率没有方法二高
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums);
    }

    private TreeNode buildTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        int[] left = Arrays.copyOfRange(nums, 0, index);
        int[] right = Arrays.copyOfRange(nums, index + 1, nums.length);
        // 构建左子树
        root.left = buildTree(left);
        // 构建右子树
        root.right = buildTree(right);
        return root;
    }


    // 方法二：直接在原数组上操作不同范围的下标索引完成分割数组
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }


    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {// 没有元素了
            return null;
        }
        if (rightIndex - leftIndex == 1) {// 只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
