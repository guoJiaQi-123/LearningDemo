package com.feishu._06binarttree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/12
 * @apiNote 145. 二叉树的后序遍历
 */
public class E03postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doPost(root, res);
        return res;
    }

    private void doPost(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        doPost(root.left, res);
        doPost(root.right, res);
        res.add(root.val);
    }

    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        //先定义一个变量存放当前节点
        TreeNode curr = root;
        //定义一个栈数据结构，用来存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //定义一个变量pop存放最近从栈中弹出的节点
        TreeNode pop = null;
        //当左孩子不为空或者栈中不为空，则循环
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                //如果当前节点不为空，将其放入栈中
                stack.push(curr);
                //将curr指向当前节点的左孩子
                curr = curr.left;
            } else {
                //后序遍历调用栈数据结构的peek方法，先操作栈顶元素，不急着弹出
                TreeNode peek = stack.peek();
                //如果栈顶节点的右孩子为空（右孩子不需要处理），或者与最近弹出栈的节点相同（右孩子已经处理）
                if (peek.right == null || peek.right == pop) {
                    //则将栈顶元素弹出并打印
                    pop = stack.pop();
                    res.add(pop.val);
                } else {
                    //如果不是，则将curr指向栈顶元素的右孩子
                    curr = peek.right;
                }
            }
        }
        return res;
    }
}
