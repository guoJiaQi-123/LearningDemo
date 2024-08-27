package com.feishu._06binarttree;

/**
 * @version v1.0
 * @author OldGj 2024/8/22
 * @apiNote 235. 二叉搜索树的最近公共祖先
 */
public class E32lowestCommonAncestor {
    /*
        二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }

    /*
         利用二叉搜索树树的特性，根节点的左子树全部小于根节点，右子树全部大于根节点
         那么，【如果p和q在一个节点的两侧，则这个节点就是p和q的最近公共祖先】
      */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        //  q 和 p 在curr节点的同一侧，需要继续查找
        while (curr.val < p.val && curr.val < q.val || curr.val > p.val && curr.val > q.val) {
            if (curr.val < p.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return curr;
    }

    /*
           迭代2，个人认为比上述迭代更好理解
        */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {  // 根据题意，题目中一定会有p和q的公共祖先，所以可以直接死循环，遇到符合条件的再退出即可
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 递归法做法，思路和上面类似
     * 当我们从上向下去递归遍历，第一次遇到 cur节点是数值在[q, p]区间中，那么cur就是 q和p的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor4(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor4(root.right, p, q);
        return root;
    }
}
