/**
 * @author Everett
 * @date 7/1/2021 6:41 PM
 */
package nowcoder.动态规划.股票_无限次交易;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new Solution().solution_3(prices));
    }

    /**
     * 只要这两天是涨的，那么就要这两天的收益
     * {@贪心}
     *
     * @param prices
     * @return
     */
    public int solution_1(int[] prices) {
        int ln = prices.length, r = 0; // dp[i]：第i天的最大收益
        for (int i = 1; i < ln; i++) {
            if (prices[i] > prices[i - 1]) r += prices[i] - prices[i - 1];
        }
        return r;
    }

    /**
     * {@动态规划}
     *
     * @param prices
     * @return
     */
    public int solution_2(int[] prices) {
        int ln = prices.length, dp[][] = new int[ln][2];
        // dp[i][0]：表示手里没有股票时的最大收益；dp[i][1]：表示手里有股票时的最大收益
        dp[0][1] = -prices[0];
        for (int i = 1; i < ln; i++) {
            // 如果当前手里没有股票：两种情况，前一天也没有股票，前一天有股票但是卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 如果当前手里有股票：前一天有，前一天没有但是今天买了
            // 这里其实是从dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])压缩来的，因为是无限次交易，所以就可以认为k与k-1是一样的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[ln - 1][0];
    }

    public int solution_3(int[] prices) {
        int ln = prices.length, have = -prices[0], not_have = 0, t;
        for (int i = 1; i < ln; i++) {
            t = not_have;
            not_have = Math.max(not_have, have + prices[i]);
            have = Math.max(have, t - prices[i]);
        }
        return not_have;
    }

}
