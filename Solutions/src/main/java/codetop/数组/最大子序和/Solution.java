package codetop.数组.最大子序和;

/**
 * leetcode 53
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int res = -1;
        int[] dp = new int[n];  // dp[i]：以元素i结尾的最大连续子数组的和
        dp[0] = nums[0];
        res = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] + nums[i] < nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
