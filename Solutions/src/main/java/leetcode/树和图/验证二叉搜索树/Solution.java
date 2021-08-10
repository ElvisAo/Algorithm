package leetcode.树和图.验证二叉搜索树;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
//        n2.right = n3;
        System.out.println(new Solution().isValidBST(n1));
    }

    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            boolean left = isValidBST(root.left);
            if (!left || (pre != null && pre.val >= root.val)) return false;
            pre = root;
            return isValidBST(root.right);
        }
        return true;
    }

}
