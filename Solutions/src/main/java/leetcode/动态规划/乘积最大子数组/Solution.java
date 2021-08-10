package leetcode.动态规划.乘积最大子数组;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] max_dp = new int[n], min_dp = new int[n];
        max_dp[0] = min_dp[0] = nums[0];
        int r = nums[0];
        for (int i = 1; i < n; i++) {
            max_dp[i] = Math.max(max_dp[i - 1] * nums[i], Math.max(min_dp[i - 1] * nums[i], nums[i]));
            min_dp[i] = Math.min(max_dp[i - 1] * nums[i], Math.min(min_dp[i - 1] * nums[i], nums[i]));
            r = Math.max(r, Math.max(max_dp[i], min_dp[i]));
        }
        return r;
    }
}
