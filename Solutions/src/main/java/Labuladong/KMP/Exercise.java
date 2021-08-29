package Labuladong.KMP;


public class Exercise {
    static class KMP {
        String pattern;
        int[][] dp;
        int n;

        public KMP(String pattern) {
            n = pattern.length();
            this.pattern = pattern;
            this.dp = new int[n + 1][256];
            init();
        }

        private void init() {
            int X = 0;
            dp[0][pattern.charAt(0)] = 1;
            for (int i = 1; i < n; i++) {
                for (int c = 0; c < 256; c++) {
                    if (pattern.charAt(i) == c) dp[i][c] = i + 1;
                    else dp[i][c] = dp[X][c];
                }
                X = dp[X][pattern.charAt(i)];
            }
            dp[n][pattern.charAt(n - 1)] = X;   // 如果是计算次数，则匹配到最后一个字符后，还要回到上一个影子状态
        }

        public int indexOf(String s) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                j = dp[j][s.charAt(i)];
                if (j == n) return i - j + 1;
            }
            return -1;
        }

        public int count(String s) {
            int j = 0, r = 0;
            for (int i = 0; i < s.length(); i++) {
                j = dp[j][s.charAt(i)];
                if (j == n) {
                    r++;
                    j = dp[j][s.charAt(i)]; // 让j回到影子状态
                }
            }
            return r;
        }
    }

    public static void main(String[] args) {
        String pattern = "bab", s = "abaaababab";
        KMP kmp = new KMP(pattern);
        System.out.println(kmp.count(s));
    }
}
