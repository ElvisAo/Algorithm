package nowcoder.动态规划.最长公共子串;


public class Solution {
    public static void main(String[] args) {
        String s1 = "1AB2345CD", s2 = "12345EF";
        System.out.println(new Solution().solution_3(s1, s2));
    }

    class Pair {
        int ln;
        char c;

        public Pair() {
            this.ln = 0;
        }
    }

    /**
     * {@会超空间复杂度}
     */
    public String solution_1(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        Pair[][] dp = new Pair[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = new Pair();
        for (int i = 0; i <= m; i++) dp[0][i] = new Pair();
        int r = 0, x = 0, y = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                Pair p = new Pair();
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    p.ln = dp[i - 1][j - 1].ln + 1;
                    p.c = str1.charAt(i - 1);
                }
                dp[i][j] = p;
                int old_r = r;
                r = Math.max(r, dp[i][j].ln);
                if (r != old_r) {
                    x = i;
                    y = j;
                }

            }
        }
        String ans = "";
        while (dp[x][y].ln != 0) {
            ans = dp[x][y].c + ans;
            x--;
            y--;
        }
        return ans;
    }

    /**
     * {@空间压缩-沿用上述思路}
     *
     * @param s1
     * @param s2
     * @return
     */
    public String solution_2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        Pair[][] dp = new Pair[2][m + 1];
        for (int i = 0; i < 2; i++) dp[i][0] = new Pair();
        for (int i = 0; i <= m; i++) dp[0][i] = new Pair();
        int r = 0, x = 0, y = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                Pair p = new Pair();
                int pre = i % 2 == 0 ? 1 : 0;
                int cur = i % 2 == 0 ? 0 : 1;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    p.ln = dp[pre][j - 1].ln + 1;
                    p.c = s1.charAt(i - 1);
                }
                dp[cur][j] = p;
                int old_r = r;
                r = Math.max(r, dp[cur][j].ln);
                if (r != old_r) {
                    x = i;
                    y = j;
                }
            }
        }
        String ans = "";
        while (x > 0 && y > 0 && s1.charAt(x - 1) == s2.charAt(y - 1)) {
            ans = s1.charAt(x - 1) + ans;
            x--;
            y--;
        }
        return ans;
    }

    /**
     * @param s1
     * @param s2
     * @return
     */
    public String solution_3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[2][m + 1]; // dp[i][j]：记录以s1中i结尾，s2中j结尾的公共子串的长度

        int r = 0, x = 0, y = 0;
        int pre, cur, ln;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre = i % 2 == 0 ? 1 : 0;
                cur = i % 2 == 0 ? 0 : 1;
                ln = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ln = dp[pre][j - 1] + 1;
                }
                dp[cur][j] = ln;
                int old_r = r;
                r = Math.max(r, dp[cur][j]);
                if (r != old_r) {
                    x = i;
                    y = j;
                }
            }
        }
        String ans = "";
        while (x > 0 && y > 0 && s1.charAt(x - 1) == s2.charAt(y - 1)) {
            ans = s1.charAt(x - 1) + ans;
            x--;
            y--;
        }
        return ans;
    }
}
