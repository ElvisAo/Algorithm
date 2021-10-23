package leetcode.树和图.树.翻转二叉树;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
