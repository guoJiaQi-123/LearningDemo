package com.tyut._07binarytree;

/**
 * @version v1.0
 * @author OldGj 2024/6/6
 * @apiNote 700. 二叉搜索树中的搜索
 */
public class E28searchBST {

    /**
     * 递归实现 尾递归，可以优化为迭代
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 非递归实现 迭代法
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                curr = curr.left;
            } else if (val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

}
