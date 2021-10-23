package codetop.数组.子集;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 76
 * keypoint：how to ensure there is not repeated case? start from i in the next backtrack
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> olist = new LinkedList<>();
        int n = nums.length;
        backtrack(nums, 0, new LinkedList<Integer>(), olist);
        return olist;
    }

    private void backtrack(int[] nums, int j, LinkedList<Integer> ilist, List<List<Integer>> olist) {
        olist.add(new LinkedList<>(ilist));
        for (int i = j; i < nums.length; i++) {
            ilist.add(nums[i]);
            backtrack(nums, i + 1, ilist, olist);
            ilist.remove(new Integer(nums[i]));
        }
    }
}
