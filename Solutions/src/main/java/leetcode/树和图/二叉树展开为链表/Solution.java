package leetcode.树和图.二叉树展开为链表;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    TreeNode last;   // 后一个节点

    /**
     * 递归的顺序不能换
     * 在还没操作节点右子树前，不能破坏该节点的右子树指向。所以采用后序遍历
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);    // 遍历完right，last就指向了right的根节点（后半截链表的第一个节点）
        flatten(root.left);     // 在这里就已经把左右子树的链表串起来了
        root.right = last;
        root.left = null;
        last = root;
    }
}
