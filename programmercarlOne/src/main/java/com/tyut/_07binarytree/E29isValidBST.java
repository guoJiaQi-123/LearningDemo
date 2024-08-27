package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @version v1.0
 * @author OldGj 2024/6/6
 * @apiNote 98. 验证二叉搜索树
 */
public class E29isValidBST {

    /**
     *  方法一：
     *  通过验证每个节点的上限和下限来判断一棵树是否为二叉搜索树
     *  其中，如果当前节点是父节点的左节点，则当前节点的上限为父节点的值
     *  如果当前节点是父节点的右节点，则当前节点的下限为父节点的值
     *  当前节点的值应该在【最小边界值】和【最大边界值】之间，不能等于边界值【二叉搜索树中不能存在重复节点】
     */
    public boolean isValidBST(TreeNode root) {
        return doIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doIsValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val >= maxValue || node.val <= minValue) {
            return false;
        }
        return doIsValidBST(node.left, minValue, node.val) && doIsValidBST(node.right, node.val, maxValue);
    }


    /**
      *  方法二：递归法中序遍历，每遍历到一个节点，都和其父节点进行比较，如果父节点的值大于等于当前节点，返回false
      *  【对于二叉搜索树来说，其中序遍历的结果应该是递增且没有重复值的】
     */
    Integer prev = Integer.MIN_VALUE;


    public boolean isValidBST2(TreeNode root) {
        return doIsValidBST2(root);
    }

    private boolean doIsValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = doIsValidBST2(node.left);
        // 中序遍历
        if (!left) {
            return false;
        }
        if (prev >= node.val) {
            return false;
        }
        // 记录当前节点，作为下一个父节点
        prev = node.val;
        return doIsValidBST2(node.right);
    }

    /*
            中序遍历非递归实现：每遍历到一个节点，都和其父节点进行比较，如果父节点的值大于等于当前节点，返回false
     */
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        long prev = Long.MIN_VALUE;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                // 处理节点值
                if (prev >= pop.val) {
                    return false;
                }
                // 在二叉树的遍历中，如果想要记录父节点的值【用pre节点记录cur节点的前一个节点】
                // 就在将当前节点指向子字节时将当前节点记录下来
                prev = pop.val;
                curr = pop.right;
            }
        }
        return true;
    }
}
