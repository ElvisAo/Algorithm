package 真题.面试真题.腾讯.粉刷房子;

public class Solution {
    public static void main(String[] args) {
        int[][] cost = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(solution_1(cost));
    }

    public static int solution_1(int[][] cost) {
        if (cost == null || cost.length == 0) return 0;
        int n = cost.length, m = cost[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) dp[0][i] = cost[0][i];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
