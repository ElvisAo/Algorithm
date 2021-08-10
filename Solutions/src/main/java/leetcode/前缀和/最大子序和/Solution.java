package leetcode.前缀和.最大子序和;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(new Solution().solution_1(arr));
    }

    /***
     * 前缀和
     * @param nums
     * @return
     */
    public int solution_1(int[] nums) {
        int n = nums.length, preSum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int r = nums[0];
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                r = Math.max(preSum[end] - preSum[start], r);
            }
        }
        return r;
    }

    /**
     * 贪心，如果前面的和<0，丢弃，否则加上当前数
     *
     * @param nums
     * @return
     */
    public int solution_2(int[] nums) {
        int r = nums[0], preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preSum < 0) preSum = nums[i];
            else preSum += nums[i];
            r = preSum > r ? preSum : r;
        }
        return r;
    }

    /**
     * 动态规划：其实还是贪心的思想
     */
    public int solution_3(int[] nums) {
        int n = nums.length, dp[] = new int[n], r = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            r = dp[i] > r ? dp[i] : r;
        }
        return r;
    }
}
