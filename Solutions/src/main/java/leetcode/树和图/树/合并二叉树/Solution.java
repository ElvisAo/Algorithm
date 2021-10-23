package leetcode.树和图.树.合并二叉树;

import common.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        } else return root1 == null ? root2 : root1;
    }
}
