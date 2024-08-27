package com.tyut._07binarytree;

/**
 * @version v1.0
 * @author OldGj 2024/6/25
 * @apiNote 669. 修剪二叉搜索树
 */
public class E36trimBST {

    /**
     * 递归法
     */
    static class Solution {
        //确定递归函数的参数以及返回值 可以通过递归函数的返回值来移除节点。
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // 递归终止条件
            if (root == null) { // 修剪的操作并不是在终止条件上进行的，所以就是遇到空节点返回就可以了。
                return null;
            }
            // 如果当前节点小于最低下限，任然需要递归判断其右子树中是否还有满足条件的节点【二叉搜索树中右子树大于根节点】
            if (root.val < low) {
                return trimBST(root.right, low, high);
            }
            // 同样的，如果当前节点上限大于最大上限，任然需要判断其左子树是否还有满足条件的节点【二叉搜索树的左子树小于根节点】
            if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            // 修剪左子树
            // root在[low,high]范围内
            root.left = trimBST(root.left, low, high);
            // 修剪右子树
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }


    /**
     * 迭代法：
     * 整体思路：
     * 1.将根节点移动到【low,high】范围内，然后迭代删除其[左子树中小于low的节点]和[右子树中大于high的节点]
     * 2.定义一个指针遍历左子树，如果指针不为null，并且指针指向的节点左子树小于low【要删除它】
     *   则将节点指向的左孩子指向不满足条件的节点的右孩子【可能满足条件】
     * 3.指针归为到root，同上处理右子树
     */
    static class Solution2 {
        //iteration
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            // 将root节点移动到[low,high]范围内 注意是左闭右闭
            while (root != null && (root.val < low || root.val > high)) {
                if (root.val < low) {
                    root = root.right; // 小于L往右走
                } else {
                    root = root.left; // 大于R往左走
                }
            }
            // 此时root已经在[low, high] 范围内，处理左孩子元素小于L的情况
            TreeNode curr = root;
            while (curr != null) {
                while (curr.left != null && curr.left.val < low) {
                    // 删除左节点【小于low，不满足条件，但是其右孩子比他大，可能满足条件】
                    curr.left = curr.left.right;
                }
                // 继续向下判断
                curr = curr.left;
            }
            //回到根节点
            curr = root;
            //处理右子树，并删除大于high的值
            while (curr != null) {
                while (curr.right != null && curr.right.val > high) {
                    // 删除右节点【大于high，但是其左孩子比他小，有可能小于high】
                    curr.right = curr.right.left;
                }
                // 因此继续向下判断
                curr = curr.right;
            }
            return root;
        }
    }

}
