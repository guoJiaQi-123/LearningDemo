package com.feishu._06binarttree;

/**
 * @version v1.0
 * @author OldGj 2024/8/20
 * @apiNote 700. 二叉搜索树中的搜索
 */
public class E27searchBST {
    /*
        递归
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // 递归的终止条件，遇到null时说明没有找到值为val的节点，返回null
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            return searchBST(root.left, val); // 当前节点大于val，向左找
        } else if (val > root.val) {
            return searchBST(root.right, val); // 当前节点小于val，向右找
        } else {
            return root; // 找到节点，直接返回
        }
    }

    /*
        迭代
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
