package leetcode.动态规划.买卖股票的最佳时机.两次;

/**
 * leetcode 123，188
 * 动态规划，n不变，k+1，在for里对i==0进行处理，然后k从1开始
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, K = 2;
        int[][][] dp = new int[n][K + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][K][0];
    }
}
