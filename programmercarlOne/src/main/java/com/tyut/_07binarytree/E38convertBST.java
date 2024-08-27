package com.tyut._07binarytree;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/7/6
 * @apiNote 538. 把二叉搜索树转换为累加树
 */
public class E38convertBST {

    int prev = 0; // 记录前一个节点的值

    /*
        递归
     */
    public TreeNode convertBST(TreeNode root) {
        doConvert(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    private void doConvert(TreeNode root) {
        if (root == null) {
            return;
        }
        doConvert(root.right); // 右
        /*
            二叉搜索树中序遍历是升序的，反中序遍历就是降序的
            累加树的定义就是在反中序遍历的过程中，将当前节点的值＋上一节点的值作为当前节点的新值
            [2, 5, 13]  --累加-->  [20, 18, 13]
                                  [2+5+13, 5+13, 13]
         */
        root.val += prev; // 当前节点的值+前一节点的值作为当节点的值
        prev = root.val;
        doConvert(root.left); // 左
    }

    /*
         迭代
     */
    public TreeNode convertBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int prev = 0; // 记录前一个节点值
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.right; // 右
            } else {
                curr = stack.pop(); // 中
                curr.val += prev;
                prev = curr.val;
                curr = curr.left; // 左
            }
        }
        return root;
    }

    /**
     *  迭代2
     */
    static class Solution {
        public TreeNode convertBST(TreeNode root) {
            int pre = 0; // 记录前一个节点值
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) {
                return null;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.peek();
                if (curr != null) {
                    stack.pop();
                    if (curr.left != null) {     //左
                        stack.add(curr.left);
                    }
                    stack.add(curr);             //中
                    stack.add(null);
                    if (curr.right != null) {    //右
                        stack.add(curr.right);
                    }
                } else {
                    stack.pop();
                    TreeNode temp = stack.pop();
                    temp.val += pre;
                    pre = temp.val;
                }
            }
            return root;
        }
    }
}
