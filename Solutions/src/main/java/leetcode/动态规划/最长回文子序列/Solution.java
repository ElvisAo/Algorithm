package leetcode.动态规划.最长回文子序列;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int ln = s.length();
        int[][] dp = new int[ln + 1][ln + 1];   // dp[i][j]：第i个字符到第j个字符中的lps的长度
        for (int i = 0; i < ln + 1; i++) {
            dp[i][i] = 1;
            for (int j = 0; j < i; j++) dp[i][j] = 0;   // java中这里不用处理
        }
        /**
         * 最后要求的是dp[0][ln-1],而凡是最后要求dp[0][ln-1](即右上角)的情况，基本都要从下往上，从左到右计算
         * trick：除了纯粹考虑在矩阵中的形式，也要注意dp数组的定义，dp[i][j]表示i到j这个串中的最长回文子序列。由此可以推出状态转移方程
         * 或者说，正是因为定义了这样的dp数组，才决定了状态转移方程，进而决定了遍历的方式是下到上、左到右
         * 因为dp[i][j]依赖与下一行以及前一列
         */
        for (int i = ln - 1; i >= 0; i--) {
            for (int j = i + 1; j < ln; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][ln - 1];
    }
}
