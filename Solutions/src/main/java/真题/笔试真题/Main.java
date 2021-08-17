package 真题.笔试真题;

import common.TreeNode;
import common.TreeUtil;

public class Main {
    public static void main(String[] args) {
        TreeNode tree = TreeUtil.getTree();
        System.out.println(solution(tree));
    }


    public static int solution(TreeNode node) {
        if (node == null) return 0;
        helper(node);
        return max;
    }

    static int max = Integer.MIN_VALUE;

    private static int helper(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int left = solution(node.left);
        int right = solution(node.right);
        max = Math.max(Math.max(max, node.val + (Math.max(left, right))), Math.max(node.val, Math.max(left, right)));
        return Math.max(Math.max(left, right), Math.max(node.val, Math.max(left, right) + node.val));
    }
}
