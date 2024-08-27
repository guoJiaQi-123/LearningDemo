package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/6/27
 * @apiNote 108. 将有序数组转换为二叉搜索树
 */
public class E37sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    // 左闭右闭区间[left, right]
    private TreeNode doSortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 找有序数组中间的值就是根节点的值
        int mid = start + (end - start) / 2;
        // 构造根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 拆分数组并使用左数组构造左子树
        root.left = doSortedArrayToBST(nums, start, mid - 1);
        // 右数组构造右子树
        root.right = doSortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    /*
        迭代法
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        // 根节点入队列
        nodeQueue.offer(root);
        // 0为左区间下标初始位置
        leftQueue.offer(0);
        // nums.length() - 1为右区间下标初始位置
        rightQueue.offer(nums.length - 1);
        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            Integer left = leftQueue.poll();
            Integer right = rightQueue.poll();
            int mid = left + (right - left) / 2;
            // 将mid对应的元素给中间节点
            currNode.val = nums[mid];
            // 处理左区间
            if (left <= mid - 1) {
                // 必须将当前节点和子节点相连
                currNode.left = new TreeNode(-1);
                // 将子节点加入队列准备赋值
                nodeQueue.offer(currNode.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }
            // 处理右区间
            if (right >= mid + 1) {
                currNode.right = new TreeNode(-1);
                nodeQueue.offer(currNode.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }
        return root;
    }

}
