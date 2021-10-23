package codetop.数组.从前序与中序遍历序列构造二叉树;

import common.TreeNode;

/**
 * leetcode 105
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recreateTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recreateTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (is > ie || ps > pe) return null;
        TreeNode root = null;
        for (int i = is; i <= ie; i++) {
            if (preorder[ps] == inorder[i]) {
                root = new TreeNode(preorder[ps]);
                root.left = recreateTree(preorder, ps + 1, ps + i - is, inorder, is, i - 1);
                root.right = recreateTree(preorder, ps + i - is + 1, pe, inorder, i + 1, ie);
                break;
            }
        }
        return root;
    }
}
