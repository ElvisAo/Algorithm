package leetcode.动态规划.背包问题.零钱兑换_完全背包_求最少硬币数;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 11;
        System.out.println(new Exercise().solution_3(coins, target));
    }

    public int solution_1(int[] coins, int amount) {
        int ln = coins.length;
        int[][] dp = new int[ln + 1][amount + 1];
        for (int i = 0; i <= ln; i++) {
            Arrays.fill(dp[i], amount + 2);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[ln][amount] == amount + 2 ? -1 : dp[ln][amount];
    }

    public int solution_3(int[] coins, int amount) {
        int ln = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 2);
        dp[0] = 0;
        for (int i = 0; i < ln; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 2 ? -1 : dp[amount];
    }

    /**
     * 递归，会栈溢出
     *
     * @param coins
     * @param amount
     * @return
     */
    public int solution_2(int[] coins, int amount) {
        r = amount + 2;
        helper(coins, amount, 0, 0);
        return r == amount + 2 ? -1 : r;
    }

    static int r;

    private void helper(int[] coins, int amount, int sum, int counter) {
        if (sum == amount) {
            r = Math.min(r, counter);
            return;
        } else if (sum > amount) return;
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            helper(coins, amount, sum + coins[i], counter + 1);
        }
    }
}
