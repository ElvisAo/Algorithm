package leetcode.树和图.树.二叉树的最近公共祖先;

import common.TreeNode;

/***
 * leetcode 235
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else return left == null ? right : left;
    }
}
