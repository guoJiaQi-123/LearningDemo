package com.feishu._06binarttree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/8/18
 * @apiNote 105. 从前序与中序遍历序列构造二叉树
 */
public class E24buildTree {

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return doBuildTree(preorder, inorder);
    }

    private TreeNode doBuildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Integer rootIndex = map.get(preorder[0]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = doBuildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = doBuildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
    }
}
