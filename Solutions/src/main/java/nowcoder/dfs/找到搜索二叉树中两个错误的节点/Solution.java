package nowcoder.dfs.找到搜索二叉树中两个错误的节点;

import common.TreeNode;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode<>(6);
        TreeNode<Integer> t2 = new TreeNode<>(8);
        TreeNode<Integer> t3 = new TreeNode<>(4);
        t1.left = t2;
        t1.right = t3;
        int[] r = new Solution().findError(t1);
        System.out.println(Arrays.toString(r));
    }

    public int[] findError(TreeNode<Integer> root) {
        inOrder(root);
        int[] r = {s, f};
        return r;
    }

    private void inOrder(TreeNode<Integer> root) {
        if (root == null) return;
        inOrder(root.left);
        if ((pre != null) && (pre.val > root.val)) {
            if (f == Integer.MIN_VALUE) f = pre.val;
            /**
             * {@注意这里是对root}
             */
            else s = root.val;
        }
        pre = root;
        inOrder(root.right);
    }

    int f = Integer.MIN_VALUE, s;
    TreeNode<Integer> pre;
}
