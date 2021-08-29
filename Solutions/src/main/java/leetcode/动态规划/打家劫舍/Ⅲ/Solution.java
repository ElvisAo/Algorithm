package leetcode.动态规划.打家劫舍.Ⅲ;

import common.TreeNode;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int solution_1(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int do_it = root.val + (root.left == null ? 0 : solution_1(root.left.left) + solution_1(root.left.right)) + (root.right == null ? 0 : solution_1(root.right.left) + solution_1(root.right.right));
        int not_do = solution_1(root.left) + solution_1(root.right);
        int r = Math.max(do_it, not_do);
        memo.put(root, r);
        return r;
    }

    public int solution_2(TreeNode root) {
        if (root == null) return 0;
        int[] r = helper(root);
        return r[0] > r[1] ? r[0] : r[1];
    }

    /**
     * 返回一个长度为2的数组，分别表示抢和不抢root
     * {@b本质是后序遍历}
     *
     * @param root
     * @return
     */
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int do_it = root.val + left[0] + right[0];  // 先看下一行注释：但是当前抢，那么下家一定不抢
        int not_do = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);    // 当前不抢，下家不一定抢，取决于收益，并且两个下家的决定可能不相同
        return new int[]{not_do, do_it};
    }
}
