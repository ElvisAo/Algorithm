package leetcode.树和图.树.删除二叉搜索树中的节点;

import common.TreeNode;

/**
 * leetcode 450
 * 递归用得非常好
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key > root.val) root.right = deleteNode(root.right, key);
        if (key == root.val) {
            if (root.left == null && root.right == null) return null;
            if (root.left == null && root.right != null) return root.right;
            if (root.left != null && root.right == null) return root.left;
            TreeNode t = root.right;
            while (t.left != null) t = t.left;
            root.val = t.val;
            root.right = deleteNode(root.right, t.val);
        }
        return root;
    }
}
