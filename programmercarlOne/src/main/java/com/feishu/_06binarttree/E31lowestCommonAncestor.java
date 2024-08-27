package com.feishu._06binarttree;


/**
 * @version v1.0
 * @author OldGj 2024/8/21
 * @apiNote 236. 二叉树的最近公共祖先
 */
public class E31lowestCommonAncestor {
    /*
        求最近公共祖先，要从下向上遍历，那么就要使用后序遍历，在遍历过程中，如果我们遇到了目标节点，就向上返回。
        遍历到父节点时
        1.判断如果左右子节点同时不为null，则说明遇到了目标节点，那么自己就是最近的父节点，则向上返回自己
        2.判断如果左右子节点一个为null，一个不为null，则向上返回不为null的那个值，因为那个值就是目标节点的值
        3.判断如果左右子节点都为null，则向上返回null
        通过上述递归，就会将第一个遇到的左右子树不为null的祖先节点返回，这个节点就是最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果遍历到的节点为目标节点或者为null，则返回【向上回溯】
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 后序遍历
        // 这道题要求公共祖先，就要从下向上遍历，那么后序遍历就是天然的从下向上遍历
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }
}
