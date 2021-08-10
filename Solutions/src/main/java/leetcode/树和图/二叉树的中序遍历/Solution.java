package leetcode.树和图.二叉树的中序遍历;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /**
     * {@递归}
     *
     * @param root
     * @return
     */
    public List<Integer> solution_1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<Integer> solution_2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (!stack.isEmpty() || t != null) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                list.add(t.val);
                t = t.right;
            }
        }
        return list;
    }
}
