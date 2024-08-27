package com.feishu._06binarttree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/12
 * @apiNote 94. 二叉树的中序遍历
 */
public class E02inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doInorder(root, res);
        return res;
    }

    private void doInorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        doInorder(root.left, res);
        res.add(root.val);
        doInorder(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                curr = pop.right;
            }
        }
        return res;
    }
}
