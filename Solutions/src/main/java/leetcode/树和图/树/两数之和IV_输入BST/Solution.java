package leetcode.树和图.树.两数之和IV_输入BST;

import common.TreeNode;

import java.util.HashSet;
import java.util.Stack;

public class Solution {
    /**
     * 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        HashSet<Integer> memo = new HashSet<>();
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            if (memo.contains(k - t.val)) return true;
            memo.add(t.val);
            t = t.right;
        }
        return false;
    }
}
