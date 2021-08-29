package leetcode.动态规划.背包问题.零钱兑换_完全背包_求最少硬币数;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        System.out.println(new Exercise().solution_1(coins, target));
    }

    public int solution_1(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];    // dp[i][j]：前i种硬币，凑j元，所需的最少个数
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], amount + 2);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {    // 如果能放进去
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {    // 如果放不进去
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount] == amount + 2 ? -1 : dp[n][amount];
    }

    public int solution_2(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);  // 算到第j个的时候，所依赖的上一次的结果没有被覆盖，所以直接从前往后遍历即可
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
