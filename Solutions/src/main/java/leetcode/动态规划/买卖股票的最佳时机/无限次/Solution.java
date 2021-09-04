package leetcode.动态规划.买卖股票的最佳时机.无限次;

/**
 * leetcode 122
 */
public class Solution {
    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int solution_1(int[] prices) {
        int n = prices.length, r = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i + 1] > prices[i]) r += prices[i + 1] - prices[i];
        }
        return r;
    }

    /**
     * 动态规划
     */
    public int solution_2(int[] prices) {
        int n = prices.length, r = 0;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 动态规划+空间压缩
     *
     * @param prices
     * @return
     */
    public int solution_3(int[] prices) {
        int n = prices.length, r = 0;
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, dp_0 - prices[i]);
        }
        return dp_0;
    }
}
