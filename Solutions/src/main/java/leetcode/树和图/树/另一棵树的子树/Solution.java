package leetcode.树和图.树.另一棵树的子树;

import common.TreeNode;

/**
 * leetcode 572
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot) || subRoot == null) return true;
        if (root != null)
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        else return false;
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            if (root == null) {
                return true;
            } else {
                return false;
            }
        }
        if (root == null) return false;
        if (root.val == subRoot.val) {
            return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
