package leetcode.树和图.树.二叉搜索树的最小绝对差;

import common.TreeNode;

/**
 * leetcode 530
 */
public class Solution {
    TreeNode pre;
    int minAbs = Integer.MAX_VALUE;

    /**
     * 中序
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return minAbs;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            getMinimumDifference(root.left);
            if (pre != null && minAbs > root.val - pre.val) {
                minAbs = root.val - pre.val;
            }
            pre = root;
            getMinimumDifference(root.right);
        }
    }
}
