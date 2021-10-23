package leetcode.树和图.树.KthSmallestElementinaBST;

import common.TreeNode;

import java.util.Stack;

/**
 * leetcode 230
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return preorder(root, k);
    }

    public int preorder(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode t = root;
        int i = 0;
        while (!stack.isEmpty() || t != null) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            i++;
            if (i == k) return t.val;
            t = t.right;
        }
        return -1;
    }
}
