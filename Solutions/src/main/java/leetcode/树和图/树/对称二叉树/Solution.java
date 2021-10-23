package leetcode.树和图.树.对称二叉树;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left != null && right != null) {
            if (left.val == right.val) {
                boolean l = isSymmetric(left.left, right.right);
                if (l) return isSymmetric(left.right, right.left);
                else return false;
            }
            return false;
        } else return false;
    }
}
