package nowcoder.动态规划.最长公共子序列_II;

public class Solution {
    public static void main(String[] args) {
        String s1 = "abcde", s2 = "aacbe";
        System.out.println(new Solution().LCS(s1, s2));
    }

    public String LCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];     // dp[i][j]：以i，j结尾的字符串的公共子序列的长度

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 其实dp[i-1][j-1]已经肯定小于另外两个了
            }
        }
        if (dp[n][m] == 0) return "-1";
        String r = "";
        while (n >= 1 && m >= 1) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                r = s1.charAt(n - 1) + r;
                System.out.println(r);
                n--;
                m--;
            } else {
                // 等于随便加在哪个分支上都行
                if (dp[n][m - 1] >= dp[n - 1][m]) m--;
                else if (dp[n - 1][m] > dp[n][m - 1]) n--;
            }
        }
        return r == "" ? "-1" : r;
    }
}
