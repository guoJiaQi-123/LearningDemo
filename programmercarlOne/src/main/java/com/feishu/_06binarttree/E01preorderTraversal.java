package com.feishu._06binarttree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/12
 * @apiNote 144. 二叉树的前序遍历
 */
public class E01preorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doPre(root, res);
        return res;
    }

    private void doPre(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        doPre(root.left, res);
        doPre(root.right, res);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return res;
    }

}
