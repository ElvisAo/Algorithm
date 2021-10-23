package Labuladong及巧妙算法.树和图.树.重建二叉树.中序和后序重建;

import common.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length - 1;
        return recreateTree(inorder, 0, n, postorder, 0, n);
    }

    /**
     * 类似前序+中序构建二叉树
     */
    private TreeNode recreateTree(int[] inOrder, int is, int ie, int[] postOrder, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postOrder[pe]);
        for (int i = is; i <= ie; i++) {
            if (postOrder[pe] == inOrder[i]) {
                root.left = recreateTree(inOrder, is, i - 1, postOrder, ps, ps + i - is - 1);
                root.right = recreateTree(inOrder, i + 1, ie, postOrder, ps + i - is, pe - 1);
                break;
            }
        }
        return root;
    }
}
