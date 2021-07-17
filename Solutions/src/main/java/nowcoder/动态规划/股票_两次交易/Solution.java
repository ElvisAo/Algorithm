package nowcoder.动态规划.股票_两次交易;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * {@动态规划}
     *
     * @param prices
     * @return
     */
    public int solution_1(int[] prices) {
        int ln = prices.length;
        int[][][] dp = new int[ln][2 + 1][2];   // 注意这里第二维为k+1的妙处，简化了对后续k==0的判断
        for (int i = 0; i < ln; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < ln; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[ln - 1][2][0];
    }

    /**
     * {@动态规划+空间优化}
     *
     * @param prices
     * @return
     */
    public int solution_2(int[] prices) {
        int ln = prices.length;
        int[][] dp = new int[3][2];
        for (int i = 0; i < ln; i++) dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < ln; i++) {
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[k][0] = 0;
                    dp[k][1] = -prices[i];
                } else {
                    dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i]);
                    dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - prices[i]);
                }
            }
        }
        return dp[2][0];
    }
}
