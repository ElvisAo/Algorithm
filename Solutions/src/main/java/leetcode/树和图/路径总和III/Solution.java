package leetcode.树和图.路径总和III;

import common.TreeNode;

import java.util.LinkedList;

/**
 * TODO 待完成
 */
public class Solution {
    int counter = 0;

    public int pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, 0, targetSum, path);
        return counter;
    }

    private void dfs(TreeNode root, int sum, int targetSum, LinkedList<Integer> path) {

    }
}
