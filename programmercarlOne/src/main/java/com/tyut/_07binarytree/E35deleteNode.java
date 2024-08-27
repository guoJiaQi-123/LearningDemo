package com.tyut._07binarytree;

import com.sun.source.tree.CompilationUnitTree;

/**
 * @version v1.0
 * @author OldGj 2024/6/23
 * @apiNote 450. 删除二叉搜索树中的节点
 */
public class E35deleteNode {
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        // 寻找待删除节点
        while (cur != null && cur.val != key) {
            curParent = cur; // 记录父节点
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        // 此时的cur就是待删除节点，如果cur==null，说明没有找到待删除节点，返回原根节点root
        if (cur == null) {
            return root;
        }
        // 待删除节点为根节点，直接将待删除节点置为null
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) { // 待删除节点只有左孩子，直接将待删除节点置为其左孩子，表示删除了自身
            cur = cur.left;
        } else if (cur.left == null) { // 同上
            cur = cur.right;
        } else { // 待删除节点既有左孩子又有右孩子
            TreeNode successor = cur.right;
            TreeNode successorParent = cur; // 定义后继节点，和后继节点的父节点
            // 找待删除节点的后继节点
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            // 如果后继节点的父节点==待删除节点，说明后继节点和待删除节点相邻，先直接删除后继节点，后序将后继节点替换待删除节点
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else { // 如果不相邻，则将后继节点父节点的左孩子赋值为后继节点的右孩子
                // 本质上还是要删除后继节点，因为如果不相邻的话，后继节点一定是其父节点的左孩子，而后继节点也只有右孩子
                successorParent.left = successor.right;
            }
            // 删除 后继节点后，将后继节点的左右孩子都赋值为待删除节点的左右孩子
            successor.right = cur.right;
            successor.left = cur.left;
            // 后继节点替换待删除节点
            cur = successor;
        }
        // 如果待删除节点父节点为null，说明删除的是根节点，则返回新的根节点就是cur
        if (curParent == null) {
            return cur;
        } else { // 待删除节点为父节点的左孩子，则将删除后的cur节点赋值给父节点的左孩子
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else { //反之赋值给右孩子
                curParent.right = cur;
            }
            return root;
        }
    }


    /**
     * 递归法
     * 参数：二叉搜索树根节点，待删除节点值key
     * 返回值：删除后的根节点
     */
    public static TreeNode deleteNode2(TreeNode root, int key) {
        // 递归的终止条件
        if (root == null) {
            return null;
        }
        // 单层递归的逻辑
        if (root.val == key) { // 需要删除root
            if (root.left == null) { // 情况1，2：待删除节点没有孩子或者只有右孩子
                return root.right;
            } else if (root.right == null) {// 情况3：待删除节点只有右孩子
                return root.left;
            } else { // 情况4:待删除节点既有左孩子又有右孩子
                TreeNode s = root.right; // 后继节点
                while (s.left != null) {
                    s = s.left;
                }
                s.left = root.left; // 将待删除节点的左孩子挂到后继节点的左孩子上
                root = root.right; // 删除待删除节点
                return root;
            }
        }
        root.left = deleteNode2(root.left, key);
        root.right = deleteNode2(root.right, key);
        return root;
    }
}
