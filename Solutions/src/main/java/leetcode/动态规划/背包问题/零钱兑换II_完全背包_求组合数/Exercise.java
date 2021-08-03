package leetcode.动态规划.背包问题.零钱兑换II_完全背包_求组合数;

public class Exercise {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(new Exercise().solution_2(coins, amount));
    }

    /**
     * {@完全背包：注意凑0元时方案数始终为1}
     *
     * @param coins
     * @param amount
     * @return
     */
    public int solution_1(int[] coins, int amount) {
        int ln = coins.length;
        int[][] dp = new int[ln + 1][amount + 1];   // dp[i][j]：用前i个硬币凑j元的组合数
        for (int i = 0; i <= ln; i++) dp[i][0] = 1;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[ln][amount];
    }

    public int solution_2(int[] coins, int amount) {
        int ln = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0)
                    dp[j] = dp[j] + dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}
