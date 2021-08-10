package leetcode.回溯.组合总和;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@注意：回溯中使用start可以保证有序}
 * 和{@link nowcoder.递归与回溯.加起来和为目标值的组合}一样
 */
public class Solution {
    public static void main(String[] args) {
        int cand[] = {2, 3, 5}, target = 8;
        List<List<Integer>> olist = new Solution().combinationSum(cand, target);
        olist.stream().forEach(x -> System.out.println(x));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> olist = new ArrayList<>();
        backtrack(candidates, target, 0, path, 0, olist);
        return olist;
    }

    private void backtrack(int[] candidates, int target, int sum, LinkedList<Integer> path, int start, List<List<Integer>> olist) {
        if (sum == target) {
            olist.add(new ArrayList<>(path));
            return;
        } else if (sum > target || start == candidates.length) return;
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) continue;
            path.addLast(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], path, i, olist);
            path.removeLast();
        }
    }
}
