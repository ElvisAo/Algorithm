package 最长公共子序列;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ln1 = text1.length(), ln2 = text2.length();
        int[][] dp = new int[ln1 + 1][ln2 + 1]; // dp[i][j]表示text1的前i个字符和text2的前j个字符中的最长公共子序列的长度
        for (int i = 0; i < ln1 + 1; i++) dp[i][0] = 0;
        for (int i = 0; i < ln2 + 1; i++) dp[0][i] = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i + 1][j + 1] = dp[i][j] + 1;
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[ln1][ln2];
    }
}
