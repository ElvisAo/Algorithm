package leetcode.树和图.N叉树的最大深度;

import common.Node;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int depth = 0;

    public int solution_1(Node root) {
        if (root == null) return depth;
        helper(root, 0);
        return depth;
    }

    private void helper(Node root, int curDepth) {
        List<Node> children = root.children;
        if (children.size() == 0) depth = Math.max(depth, curDepth + 1);
        children.stream().forEach(x -> helper(x, curDepth + 1));
        return;
    }

    public int solution_2(Node root) {
        Node t = root;
        LinkedList<Node> q = new LinkedList<>();
        q.offer(t);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                t = q.poll();
                if (t != null) {
                    List<Node> children = t.children;
                    children.stream().forEach(x -> q.offer(x));
                }
            }
            depth++;
        }
        return depth;
    }
}
