package com.tyut._07binarytree;

/**
 * @version v1.0
 * @author OldGj 2024/6/23
 * @apiNote 701. 二叉搜索树中的插入操作
 */
public class E34insertIntoBST {

    /*
        迭代法，先找到待插入节点的位置，然后记录待插入节点的父节点，最后通过于父节点的判断觉得插入父节点的左边还是右边
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        // 寻找插入位置
        TreeNode curr = root;
        TreeNode prev = null; // 记录父节点，如果最后遍历到合适的插入位置，需要根据父节点插入父节点的左孩子或者右孩子
        while (curr != null) {
            if (curr.val > val) {
                prev = curr;
                curr = curr.left;
            } else if (curr.val < val) {
                prev = curr;
                curr = curr.right;
            }
        }
        // 如果父节点的值大于待插入元素的值，则插入到父节点的左边，反之插入右边
        if (prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }
        return root;
    }


    /**
     * 递归法
     */
    static class Solution {
        // 参数：二叉树根节点和待插入数值
        // 返回值：插入的节点
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // 终止条件：如果遍历到null，说明找到了插入位置，返回插入的节点即可
            if (root == null) { // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
                return new TreeNode(val);
            }
            // 单层递归的逻辑
            if (root.val < val) {
                root.right = insertIntoBST(root.right, val); // 递归创建右子树
            } else if (root.val > val) {
                root.left = insertIntoBST(root.left, val); // 递归创建左子树
            }
            return root;

        }
    }
}
