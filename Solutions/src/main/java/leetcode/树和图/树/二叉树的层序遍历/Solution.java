package leetcode.树和图.树.二叉树的层序遍历;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode t = root;
        List<List<Integer>> olist = new LinkedList<>();
        if (t == null) return olist;
        q.offer(t);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> ilist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                t = q.poll();
                ilist.offer(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            olist.add(ilist);
        }
        return olist;
    }
}
