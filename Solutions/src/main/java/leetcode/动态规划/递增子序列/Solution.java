package leetcode.动态规划.递增子序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] t = {4, 4, 3, 2, 1};
        System.out.println(new Solution().findSubsequences(t));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        int ln = nums.length;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
//        boolean[] visited = new boolean[ln];
        backtrack(nums, 0, new ArrayList<Integer>(), set);
        List<List<Integer>> olist = new ArrayList<>();
        set.stream().forEach(x -> olist.add(x));
        return olist;
    }

    private void backtrack(int[] nums, int start, ArrayList<Integer> path, HashSet<ArrayList<Integer>> set) {
        int ln = nums.length;
        if (path.size() > 1) {
            set.add(new ArrayList<>(path));
        }
//        System.out.println(path);
        if (path.size() == ln) return;
        for (int i = start; i < ln; i++) {
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
//                visited[i] = true;
                path.add(nums[i]);
                backtrack(nums, i + 1, path, set);
                path.remove(path.size() - 1);
//                visited[i] = false;
            }
        }
    }

}
