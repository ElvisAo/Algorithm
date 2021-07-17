package nowcoder.动态规划.股票_一次交易;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution_1(int[] prices) {
        int min = Integer.MAX_VALUE, r = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            r = Math.max(r, prices[i] - min);
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
        int ln = prices.length;
        int[][] dp = new int[ln][2];
        for (int i = 0; i < ln; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[ln - 1][0];
    }

    /**
     * {@动态规划+空间优化 }
     *
     * @param prices
     * @return
     */
    public int solution_3(int[] prices) {
        int ln = prices.length;
        int not = 0, have = 0;
        for (int i = 0; i < ln; i++) {
            if (i == 0) {
                not = 0;
                have = -prices[0];
            } else {
                not = Math.max(not, have + prices[i]);
                have = Math.max(have, -prices[i]);
            }
        }
        return not;
    }
}
