package Labuladong及巧妙算法.树和图.树.重建二叉树.前序和后序重建;

import common.TreeNode;

/**
 * 递归，先利用前序从后序中找到下一次的分割，从而才能确定每次分割的长度
 */
public class Exercise {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length - 1;
        return recreateTree(pre, 0, n, post, 0, n);
    }

    private TreeNode recreateTree(int[] pre, int prs, int prt, int[] post, int pos, int pot) {
        if (pos > pot || prs > prt) return null;
        TreeNode root = new TreeNode(pre[prs]);
        if (prs == prt) {
            return root;
        }
        int index = pos;
        while (pre[prs + 1] != post[index]) index++;
        root.left = recreateTree(pre, prs + 1, prs + 1 + index - pos, post, pos, index);
        root.right = recreateTree(pre, prs + 2 + index - pos, prt, post, index + 1, pot);
        return root;
    }
}
