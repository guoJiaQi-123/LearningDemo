package com.tyut._07binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/5/16
 * @apiNote 106. 从中序与后序遍历序列构造二叉树
 */
public class E23buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {


        /*

        输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
            输出：[3,9,20,null,null,15,7]


        */
        //递归结束条件
        if (inorder.length == 0) {
            return null;
        }
        //后序遍历数组的最后一个值一定是根节点的值
        int rootValue = postorder[postorder.length - 1];
        //有了根节点的值，创建根节点
        TreeNode root = new TreeNode(rootValue);
        //拿根节点的值，去中序遍历数组中找根节点的位置
        for (int i = 0; i < inorder.length; i++) {
            //在中序遍历数组中找到根节点位置
            if (inorder[i] == rootValue) {

                //根据根节点位置划分数组
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                //划分后序遍历数组
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                //分别把后序数组左部分和中序数组左部分，以及后序数组右部分和中序数组右部分看做一颗数的后序遍历和中序遍历
                //递归调用buildTree方法返回根节点作为上一次返回根的左子树节点以及右子树节点
                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);

                // ** 切记！！ 在中序遍历数组中找到根的值后要跳出循环
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        // 后序遍历的最后一个数一定是根节点的值
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        // 拿根节点的值去前序遍历的数组中找根节点的位置
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {

                // 找到根节点的位置后，构造根节点左子树的中序遍历数组
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                //划分后序遍历数组
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                root.left = buildTree2(inLeft, postLeft);
                root.right = buildTree2(inRight, postRight);
                // 找到根节点的位置要退出外层循环
                break;
            }
        }
        return root;
    }

    static class Solution {
        Map<Integer, Integer> map;  // 方便根据数值查找位置

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
                map.put(inorder[i], i);
            }

            return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);  // 前闭后开
        }


        public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
            // 参数里的范围都是前闭后开
            if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
                return null;
            }
            int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
            TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
            int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
            root.left = findNode(inorder, inBegin, rootIndex,
                    postorder, postBegin, postBegin + lenOfLeft);
            root.right = findNode(inorder, rootIndex + 1, inEnd,
                    postorder, postBegin + lenOfLeft, postEnd - 1);

            return root;
        }
    }
}
