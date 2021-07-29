package leetcode.动态规划.最长回文子序列;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int ln = s.length();
        int[][] dp = new int[ln + 1][ln + 1];   // dp[i][j]：第i个字符到第j个字符中的lps的长度
        for (int i = 0; i < ln + 1; i++) {
            dp[i][i] = 1;
            for (int j = 0; j < i; j++) dp[i][j] = 0;
        }
        for (int i = ln - 1; i >= 0; i--) {
            for (int j = i + 1; j < ln; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][ln-1];
    }
}
