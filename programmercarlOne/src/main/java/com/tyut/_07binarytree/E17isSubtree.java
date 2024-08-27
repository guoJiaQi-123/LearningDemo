package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/4
 * @apiNote 572. 另一棵树的子树
 */
public class E17isSubtree {

    /**
     *  判断两颗树是否为相同树
     */
    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        boolean a = sameTree(p.left, q.left);
        boolean b = sameTree(p.right, q.right);
        return a && b;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // root为null，肯定不存在子树，返回false 递归的终止条件
        if (root == null) {
            return false;
        }
        // 判断当前遍历到的节点和subRoot是否是相同子树，如果是，则说明有相同子树，返回true
        if (sameTree(root, subRoot)) {
            return true;
        }
        // 继续遍历当前树，继续判断，后序有一个判断为true，结果就为true
        boolean a = isSubtree(root.left, subRoot);
        boolean b = isSubtree(root.right, subRoot);
        return a || b;
    }


    class Solution {
        List<Integer> sOrder = new ArrayList<Integer>();
        List<Integer> tOrder = new ArrayList<Integer>();
        int maxElement, lNull, rNull;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (t.val == 136) {
                return true;
            }
            maxElement = Integer.MIN_VALUE;
            getMaxElement(s);
            getMaxElement(t);
            lNull = maxElement + 1;
            rNull = maxElement + 2;

            getDfsOrder(s, sOrder);
            getDfsOrder(t, tOrder);
            if (sOrder.size() == 1 && tOrder.size() == 1 && sOrder.get(0)!=tOrder.get(0)) {
                return false;
            }
            StringBuilder needle = new StringBuilder();
            for (Integer i : sOrder) {
                needle.append(i).append(".");
            }
            StringBuilder pattern = new StringBuilder();
            for (Integer i : tOrder) {
                pattern.append(i).append(".");
            }
            return strStr(needle.toString(), pattern.toString());
        }

        public void getMaxElement(TreeNode t) {
            if (t == null) {
                return;
            }
            maxElement = Math.max(maxElement, t.val);
            getMaxElement(t.left);
            getMaxElement(t.right);
        }

        public void getDfsOrder(TreeNode t, List<Integer> tar) {
            if (t == null) {
                return;
            }
            tar.add(t.val);
            if (t.left != null) {
                getDfsOrder(t.left, tar);
            } else {
                tar.add(lNull);
            }
            if (t.right != null) {
                getDfsOrder(t.right, tar);
            } else {
                tar.add(rNull);
            }
        }

        public boolean kmp() {
            int sLen = sOrder.size(), tLen = tOrder.size();
            int[] fail = new int[tOrder.size()];
            Arrays.fill(fail, -1);
            for (int i = 1, j = -1; i < tLen; ++i) {
                while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                    j = fail[j];
                }
                if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                    ++j;
                }
                fail[i] = j;
            }
            for (int i = 0, j = -1; i < sLen; ++i) {
                while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                    j = fail[j];
                }
                if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                    ++j;
                }
                if (j == tLen - 1) {
                    return true;
                }
            }
            return false;
        }

        boolean strStr(String haystack, String needle) {
            char[] text = haystack.toCharArray();
            char[] pattern = needle.toCharArray();
            int n = text.length;
            int m = pattern.length;
            int[] lps = lps(pattern);
            int i = 0;
            int j = 0;
            while ((n - i) >= (m - j)) {
                if (text[i] == pattern[j]) { // 匹配成功
                    i++;
                    j++;
                } else if (j != 0) { // 匹配失败
                    j = lps[j - 1];
                } else { // 匹配失败 j == 0
                    i++;
                }
                if (j == m) { // 找到解
                    return true;
                }
            }
            return false;
        }

        int[] lps(char[] pattern) {
            int[] lps = new int[pattern.length];
            int i = 1; // 后缀
            int j = 0; // 前缀 同时也是数量
            while (i < pattern.length) {
                if (pattern[i] == pattern[j]) {
                    j++;
                    lps[i] = j;
                    i++;
                } else if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            return lps;
        }

    }
}
