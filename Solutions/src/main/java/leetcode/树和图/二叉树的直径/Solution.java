package leetcode.树和图.二叉树的直径;

import common.TreeNode;

public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int left = root.left == null ? 0 : 1 + helper(root.left);
        int right = root.right == null ? 0 : 1 + helper(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }
}
