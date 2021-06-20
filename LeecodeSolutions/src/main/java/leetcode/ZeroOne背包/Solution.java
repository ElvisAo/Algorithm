package leetcode.ZeroOne背包;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().knapsackspacezip(10, 2, new int[][]{{1, 3}, {10, 4}}));
    }

    /**
     * 计算01背包问题的结果
     *
     * @param V  int整型 背包的体积
     * @param n  int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack(int V, int n, int[][] vw) {
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 0; j <= V; j++) dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (j - vw[i - 1][0] < 0) dp[i][j] = dp[i - 1][j];  // 如果放不下第i个
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
            }

        }
        return dp[n][V];
    }

    public int knapsackspacezip(int V, int n, int[][] vw) {
        int[] dp = new int[V + 1];
        for (int i = 0; i <= V; i++) dp[i] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = V; j > 0; j--) {
                if (j - vw[i - 1][0] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[V];
    }
}
