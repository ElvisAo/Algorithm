package leetcode.动态规划.不同路径系列.不同路径II;

/**
 * leetcode 63
 * 动态规划，对于dp中的障碍物点，用Integer.MAX_VALUE来表示
 * 时间100，空间96
 */
public class Solution {
    public static void main(String[] args) {
        int[][] obstacles = {{0, 1}, {0, 0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacles));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i - 1][0] == 0 && dp[i - 1][0] != Integer.MAX_VALUE && obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = Integer.MAX_VALUE;
            }
        }   // 处理0列
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i - 1] == 0 && dp[0][i - 1] != Integer.MAX_VALUE && obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }   // 处理0行
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    if (dp[i - 1][j] == Integer.MAX_VALUE && dp[i][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    } else if (dp[i - 1][j] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (dp[i][j - 1] == Integer.MAX_VALUE) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n - 1][m - 1] == Integer.MAX_VALUE ? 0 : dp[n - 1][m - 1];
    }
}
