package nowcoder.树与图.在二叉树中找到两个节点的最近公共祖先;

import common.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * {@不要同时寻找两个节点，而是寻找单个节点，看两个节点各自在左右子树的分布}
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return dfs(root, o1, o2).val;
    }

    private TreeNode dfs(TreeNode node, int o1, int o2) {
        if (node == null || node.val == o1 || node.val == o2) return node;  // 如果找到了某个节点，返回
        TreeNode left = dfs(node.left, o1, o2);
        TreeNode right = dfs(node.right, o1, o2);
        if (left != null && right != null) return node;
        return left == null ? right : left;
    }
}
