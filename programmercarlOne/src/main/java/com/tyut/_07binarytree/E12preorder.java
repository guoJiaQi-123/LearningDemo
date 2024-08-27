package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 589. N 叉树的前序遍历
 */
public class E12preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        // 调用递归函数
        doPreorder(root, res);
        return res;
    }

    private void doPreorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        // 遍历当前节点的子节点，递归执行
        for (Node child : node.children) {
            doPreorder(child, list);
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            res.add(pop.val);
            if (!pop.children.isEmpty()) {
                // 当前节点的孩子需要从后往前入栈，才能从前往后出栈实现前序遍历
                for (int i = pop.children.size() - 1; i >= 0; i--) {
                    stack.push(pop.children.get(i));
                }
            }
        }
        return res;
    }


}
