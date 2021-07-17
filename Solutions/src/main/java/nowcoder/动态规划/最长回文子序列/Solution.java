package nowcoder.动态规划.最长回文子序列;

public class Solution {
    public static void main(String[] args) {
        String s = "abccsb";
        System.out.println(new Solution().solution_1(s));
    }

    /**
     * {@动态规划}
     *
     * @param s
     * @return
     */
    public int solution_1(String s) {
        int ln = s.length();
        int[][] dp = new int[ln][ln];
        for (int i = 0; i < ln; i++) dp[i][i] = 1;
        for (int i = ln - 2; i >= 0; i--) {
            for (int j = i + 1; j < ln; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][ln - 1];
    }
}
