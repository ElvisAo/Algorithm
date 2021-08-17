package leetcode.树和图.把二叉搜索树转换为累加树;

import common.TreeNode;

public class Solution {

    static int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}
