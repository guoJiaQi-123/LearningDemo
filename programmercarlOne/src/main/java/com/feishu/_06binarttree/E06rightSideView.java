package com.feishu._06binarttree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/14
 * @apiNote 199. 二叉树的右视图
 */
public class E06rightSideView {
    // 思路：层序遍历，将每一层的最后一个加入结果集合 bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 使用队列的长度表示每一层节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 将每一层的最后一个节点加入结果集合
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        // 如果根节点为空，直接返回结果集合
        if (root == null) {
            return res;
        }
        // 深度优先遍历 参数一：根节点， 参数二：当前层数
        dfs(root, 0);
        return res;
    }

    /**
     * 深度优先遍历，先遍历右孩子，再遍历左孩子
     * @param depth 当前层数
     */
    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 因为每一层都需要有一个节点加入结果集合！【这是一定的，每一层只要有节点就一定有右视图】
        // 如果当前层数等于结果集合的长度，则说明上一层刚遍历完，现在遍历的是新的一层的第一个节点
        if (depth == res.size()) {
            res.add(node.val);
        }
        // 我们定义的递归顺序就是先便利右节点，因此一定会先遍历 右视图 的节点，将该节点加入 res 中即可
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }

}
