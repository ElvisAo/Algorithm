package codetop.数组.买卖股票的最佳时机;

/**
 * leetcode 121
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], res = 0, n = prices.length;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, prices[i] - min);
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return res;
    }

    public int solution_2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2]; // dp[i][]：到第i天时，手里有无股票的最大收益
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public int solution_3(int[] prices) {
        int n = prices.length;
        int dp_0 = 0, dp_1 = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp_0 = 0;
                dp_1 = -prices[i];
                continue;
            }
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, -prices[i]);
        }
        return dp_0;
    }
}
