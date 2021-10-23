package leetcode.树和图.树.二叉树的最大深度;

import common.TreeNode;

import java.util.LinkedList;

public class Solution {
    public int solution_1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(solution_1(root.left), solution_1(root.right)) + 1;
    }

    public int solution_2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode t = root;
        q.offer(t);
        int r = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> ilist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                t = q.poll();
                ilist.offer(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            r++;
        }
        return r;
    }
}
