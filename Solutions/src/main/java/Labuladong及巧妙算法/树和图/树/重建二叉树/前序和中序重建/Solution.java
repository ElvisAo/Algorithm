package Labuladong及巧妙算法.树和图.树.重建二叉树.前序和中序重建;

import common.TreeNode;

public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        int n = pre.length - 1;
        return recreateTree(pre, 0, n, vin, 0, n);
    }

    private TreeNode recreateTree(int[] pre, int ps, int pe, int[] vin, int is, int ie) {
        TreeNode root = null;
        for (int i = is; i <= ie; i++) {
            if (vin[i] == pre[ps]) {
                root = new TreeNode(pre[ps]);
                root.left = recreateTree(pre, ps + 1, ps + i - is, vin, is, i - 1);
                root.right = recreateTree(pre, ps + i - is + 1, pe, vin, i + 1, ie);
                break;
            }
        }
        return root;
    }
}
