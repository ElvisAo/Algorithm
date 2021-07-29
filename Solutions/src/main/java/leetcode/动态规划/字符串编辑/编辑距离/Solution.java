package leetcode.动态规划.字符串编辑.编辑距离;

public class Solution {
    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        System.out.println(new Solution().minDistance(s1, s2));
    }

    public int minDistance(String word1, String word2) {
        int ln1 = word1.length(), ln2 = word2.length();
        int[][] dp = new int[ln1 + 1][ln2 + 1];
        for (int i = 0; i <= ln1; i++) dp[i][0] = i;
        for (int i = 0; i <= ln2; i++) dp[0][i] = i;
        for (int i = 1; i <= ln1; i++) {
            for (int j = 1; j <= ln2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[ln1][ln2];
    }
}
