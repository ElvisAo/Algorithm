package leetcode.动态规划.买卖股票的最佳时机.两次;

public class Exercise {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2 + 1][2];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int k = 1; i <= 2; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k - 1][0] - prices[i], dp[i - 1][k][1]);
            }
        }
        return dp[n - 1][2][0];
    }
}
