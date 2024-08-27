package com.feishu._06binarttree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/21
 * @apiNote 501. 二叉搜索树中的众数
 */
public class E30findMode {

    TreeNode prev = null;
    List<Integer> res = new ArrayList<>();
    int freq = 0;
    int maxFreq = 0;

    public int[] findMode(TreeNode root) {
        doInorder(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void doInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        doInorder(node.left);
        if (prev == null || node.val != prev.val) {
            freq = 1;
        } else {
            freq++;
        }
        if (freq == maxFreq) {
            res.add(node.val);
        } else if (freq > maxFreq) {
            res.clear();
            res.add(node.val);
            maxFreq = freq;
        }
        prev = node;
        doInorder(node.right);
    }

    /*
        优化迭代
     */
    public int[] findMode2(TreeNode root) {
        int count = 0;
        int maxCount = 0;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (prev == null || prev.val != curr.val) {
                    count = 1;
                } else {
                    count++;
                }
                if (count == maxCount) {
                    res.add(curr.val);
                } else if (count > maxCount) {
                    res.clear();
                    res.add(curr.val);
                    maxCount = count;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
