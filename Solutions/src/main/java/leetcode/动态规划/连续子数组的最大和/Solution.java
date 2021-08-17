package leetcode.动态规划.连续子数组的最大和;

public class Solution {

    /**
     * {@动态规划}
     *
     * @param nums
     * @return
     */
    public int solution_1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * {@前缀和：超时}
     *
     * @param nums
     * @return
     */
    public int solution_2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int preSum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int r = nums[0];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                r = Math.max(r, preSum[i] - preSum[j]);
            }
        }
        return r;
    }
}
