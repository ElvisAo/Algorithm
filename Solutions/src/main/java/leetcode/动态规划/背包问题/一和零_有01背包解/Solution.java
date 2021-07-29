package leetcode.动态规划.背包问题.一和零_有01背包解;

public class Solution {
    public static void main(String[] args) {

    }

    class Pair {
        int v1, v2;

        public Pair(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    /**
     * {@多维费用的01背包问题}
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            Pair p = counte(s);
            int c0 = p.v1, c1 = p.v2;
            for (int i = m; i >= c0; i--) {
                for (int j = n; j >= c1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - c0][j - c1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private Pair counte(String s) {
        int c1 = s.length(), c0 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                c0++;
                c1--;
            }
        }
        return new Pair(c0, c1);
    }
}
