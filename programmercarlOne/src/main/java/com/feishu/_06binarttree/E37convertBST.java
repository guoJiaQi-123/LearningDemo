package com.feishu._06binarttree;

/**
 * @version v1.0
 * @author OldGj 2024/8/25
 * @apiNote 538. 把二叉搜索树转换为累加树
 */
public class E37convertBST {
    TreeNode prev = null; // 定义一个指针用于记录上一个节点

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 中序遍历，但是顺序是 右 -> 中 -> 左
        convertBST(root.right); // 右
        if (prev != null) {
            root.val = prev.val + root.val; // 当前节点值更新为上一个节点值和当前节点值的累加和
        }
        prev = root; // 记录上一个节点值
        convertBST(root.left); // 左
        return root;
    }
}
