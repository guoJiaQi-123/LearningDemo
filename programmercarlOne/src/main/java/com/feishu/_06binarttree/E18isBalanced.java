package com.feishu._06binarttree;

/**
 * @version v1.0
 * @author OldGj 2024/8/17
 * @apiNote 110. 平衡二叉树
 */
public class E18isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left); // 左子树的高度
        int right = depth(root.right); // 右子树的高度
        // 如果高度差大于2，返回false
        if (Math.abs(left - right) > 1) {
            return false;
        }
        // 递归判断根节点的左右子树是否为平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 计算node为根节点的二叉树的高度
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    // 递归法二
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) != -1;
    }

    /*
        获取node节点为根的二叉树的高度，如果该二叉树不是平衡二叉树，返回-1，如果是平衡二叉树，返回高度
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left); // 右孩子的高度
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right); // 左孩子的高度
        if (rightHeight == -1) {
            return -1;
        }
        // 如果不是平衡二叉树，返回-1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 如果是平衡二叉树，返回高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
