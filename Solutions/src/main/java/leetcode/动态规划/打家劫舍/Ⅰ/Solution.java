package leetcode.动态规划.打家劫舍.Ⅰ;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * {@自顶向下的动态规划}
     *
     * @param nums
     * @return
     */
    public int solution_0(int[] nums) {
        return helper(nums, 0);
    }

    private HashMap<Integer, Integer> memo = new HashMap<>();

    private int helper(int[] nums, int start) {
        if (start == nums.length) return 0;
        if (memo.containsKey(start)) return memo.get(start);
        // 不抢，去下家；抢，去下下家
        int r = Math.max(helper(nums, start + 1), helper(nums, start + 2) + nums[start]);
        memo.put(start, r);
        return r;
    }

    public int solution_1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int solution_2(int[] nums) {
        int n = nums.length;
        int pre_0 = 0, pre_1 = nums[0], t;
        for (int i = 1; i < n; i++) {
            t = pre_0;
            pre_0 = Math.max(pre_1, pre_0);
            pre_1 = t + nums[i];
        }
        return Math.max(pre_0, pre_1);
    }
}
