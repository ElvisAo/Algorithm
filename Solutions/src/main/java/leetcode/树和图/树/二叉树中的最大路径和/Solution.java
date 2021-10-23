package leetcode.树和图.树.二叉树中的最大路径和;

import common.TreeNode;

/**
 * leetcode 124
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        postOrder(root);
        return maxSum;
    }

    int maxSum = 0;

    private int postOrder(TreeNode root) {
        if (root != null) {
            int left = postOrder(root.left);
            int right = postOrder(root.right);
            int partialMax = Math.max(root.val, Math.max(root.val + left, root.val + right));
            maxSum = Math.max(maxSum, Math.max(partialMax, root.val + left + right));
            return partialMax;
        } else return 0;
    }
}
