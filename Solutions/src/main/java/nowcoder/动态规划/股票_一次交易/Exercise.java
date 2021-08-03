package nowcoder.动态规划.股票_一次交易;

public class Exercise {
    public static void main(String[] args) {

    }

    public int solution_1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[n - 1][0];
    }
}
