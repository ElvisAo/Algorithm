package leetcode.树和图.树.递增顺序搜索树;

import common.TreeNode;

/**
 * leetcode 897
 */
public class Solution {
    TreeNode pre, head;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root != null) {
            increasingBST(root.left);
            if (pre != null) {
                pre.right = root;
            }
            if (head == null) head = root;
            root.left = null;
            pre = root;
            increasingBST(root.right);
        }
    }
}
