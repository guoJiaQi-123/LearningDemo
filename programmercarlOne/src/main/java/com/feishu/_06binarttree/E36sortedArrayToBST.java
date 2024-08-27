package com.feishu._06binarttree;

/**
 * @version v1.0
 * @author OldGj 2024/8/25
 * @apiNote 108. 将有序数组转换为二叉搜索树
 */
public class E36sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode doSortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doSortedArrayToBST(nums, left, mid - 1);
        root.right = doSortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
