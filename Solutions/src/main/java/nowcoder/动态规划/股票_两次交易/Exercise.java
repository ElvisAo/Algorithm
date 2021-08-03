package nowcoder.动态规划.股票_两次交易;

public class Exercise {
    public static void main(String[] args) {
        int[] arr = {8, 9, 3, 5, 1, 3};
        System.out.println(new Exercise().solution_1(arr));
    }

    /**
     * 只要涉及到-1的地方，都要注意越界的判断
     *
     * @param prices
     * @return
     */
    public int solution_1(int[] prices) {
        int n = prices.length, k = 2;
        int[][][] dp = new int[n][k + 1][2];    // 第i天，最多可以交易k次，手里有无股票
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][2][0];
    }
}
