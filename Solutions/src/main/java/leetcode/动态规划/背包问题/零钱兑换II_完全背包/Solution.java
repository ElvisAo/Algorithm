package leetcode.动态规划.背包问题.零钱兑换II_完全背包;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_1(new int[]{1, 2}, 5));
    }

    public int solution_1(int[] coins, int amount) {
        int ln = coins.length;
        int[][] dp = new int[ln + 1][amount + 1];
        for (int i = 0; i <= ln; i++) dp[i][0] = 1;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                int not = dp[i - 1][j];
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = not;
                    continue;
                }
                int use = dp[i][j - coins[i - 1]];  // 注意，这里没有+1
                dp[i][j] = not + use;
            }
        }
        return dp[ln][amount];
    }

    public int solution_2(int[] coins, int amount) {
        int ln = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) { // 注意：这里没有反向遍历
                if (j - coins[i - 1] >= 0) {
                    int not = dp[j];
                    int use = dp[j - coins[i - 1]];
                    dp[j] = not + use;
                }
            }
        }
        return dp[amount];
    }
}
