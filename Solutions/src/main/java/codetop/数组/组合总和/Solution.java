package codetop.数组.组合总和;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 39
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> olist = new LinkedList<>();
        List<Integer> ilist = new LinkedList<>();
        backtrack(candidates, 0, 0, target, ilist, olist);
        return olist;
    }

    private void backtrack(int[] arr, int sum, int start, int target, List<Integer> path, List<List<Integer>> olist) {
        if (sum == target) {
            olist.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] + sum > target) continue;    // 递归前判断，减少不不要的出入栈
            path.add(arr[i]);
            backtrack(arr, sum + arr[i], i, target, path, olist);
            path.remove(new Integer(arr[i]));
        }
    }
}
