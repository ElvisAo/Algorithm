package leetcode.动态规划.字符串编辑.只有两个键的键盘;

public class Solution {
    public static void main(String[] args) {

    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];  // 打印n个a的最少次数
        for (int i = 0; i <= n; i++) dp[i] = i;
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i / j]);     // i==j时，其实就执行了copyAll，从而使得击键次数+1
                }
            }
        }
        return dp[n];
    }
}
