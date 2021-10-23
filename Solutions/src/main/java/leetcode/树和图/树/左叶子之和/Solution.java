package leetcode.树和图.树.左叶子之和;

import common.TreeNode;

import java.util.Stack;

/**
 * leetcode 404
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 用中序遍历来做
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int leftSum = 0;
        if (p.left == null && p.right == null) return leftSum;  // 只有一个节点的，特殊处理
        boolean fromLeft = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                if (p.left == null && p.right == null && fromLeft) {
                    leftSum += p.val;
                }
                p = p.left;
                fromLeft = true;
            }
            p = stack.pop();
            p = p.right;
            fromLeft = false;
        }
        return leftSum;
    }

}
