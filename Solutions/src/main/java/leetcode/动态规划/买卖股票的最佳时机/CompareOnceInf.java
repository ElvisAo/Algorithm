package leetcode.动态规划.买卖股票的最佳时机;

public class CompareOnceInf {
    /**
     * 只能买一次
     *
     * @param prices
     * @return
     */
    public int once(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);  // 注意：这里不能是Math.max(dp[i-1][0]-prices[i], dp[i-1][1])
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 可以买无限次
     *
     * @param prices
     * @return
     */
    public int inf(int[] prices) {
        int n = prices.length, r = 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 1次和无限次唯一的区别就是买的时候
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
