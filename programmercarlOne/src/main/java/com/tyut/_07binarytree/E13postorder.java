package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 590. N 叉树的后序遍历
 */
public class E13postorder {

    // 递归实现
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        doPostorder(root, res);
        return res;
    }

    private void doPostorder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        node.children.forEach(child -> {
            doPostorder(child, res);
        });
        res.add(node.val);
    }

    // 迭代实现
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        // 标记节点是否被处理
        List<Node> visited = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            // 如果当前节点没有孩子，或者当前节点已经被标记（说明子节点已经处理完了，可以处理当前节点了）
            if (peek.children.isEmpty() || visited.contains(peek)) {
                Node pop = stack.pop();
                res.add(pop.val);
                continue;
            }
            for (int i = peek.children.size() - 1; i >= 0; i--) {
                stack.push(peek.children.get(i));
                // 标记当前节点的所有子节点已经全部入栈
                visited.add(peek);
            }
        }
        return res;
    }

    // 利用前序遍历反转
    public List<Integer> postorder3(Node root) {
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
                for (Node child : pop.children) {
                    stack.push(child);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

}
