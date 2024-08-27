package com.tyut._07binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/5/16
 * @apiNote 105. 从前序与中序遍历序列构造二叉树
 */
public class E24buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        // 前序遍历的第一个值一定是根节点的值
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 遍历中序数组，在中序数组中找根节点位置
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {

                // 切割中序遍历数组
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                // 切割前序遍历数组
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }

    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();// 用map保存中序序列的数值对应位置

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i); // key 前序遍历的值  value 对应的索引下标
            }
            return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
            // 参数里的范围都是前闭后开
            if (preBegin >= preEnd || inBegin >= inEnd) {  // 不满足左闭右开，说明没有元素，返回空树
                return null;
            }
            int rootIndex = map.get(preorder[preBegin]);  // 找到前序遍历的第一个元素在中序遍历中的位置
            TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
            int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定前序数列的个数
            root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                    inorder, inBegin, rootIndex);
            root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd,
                    inorder, rootIndex + 1, inEnd);

            return root;
        }

    }
}
