package leetcode.动态规划.让字符串成为回文串的最少插入次数;

public class Solution {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(new Solution().solution_2(s));
    }

    /**
     * 动态规划：
     * 1. 注意对dp的定义，对于字符串，经常是定义为dp[i][j]表示从i到jxxx
     * 2. 注意for循环的写法，由于最后是求dp[0][n-1]，所以从下往上，从左到右遍历。且base case为dp[j][j]==0 while i==j;
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j]：让i~j（包括首尾）的字符串称为回文串的最少插入次数
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * {@空间压缩}
     * 压缩思路：
     * 注意到dp[i][j]依赖于dp[i][j-1],dp[i+1][j],dp[i+1][j-1]；dp[i][j-1]与dp[i+1][j]都好处理
     * 因为i本来就是从大到小，j从小到大遍历的。当计算到dp[i][j]时，如果被压缩为一维，则原dp[j]本来就是原dp[i][j]的值
     * 而计算到dp[i][j]时，由于j从小到大，则dp[i][j-1]已经计算出来
     * 难点在于对于dp[i+1][j-1]如何处理，因为当计算到dp[i][j]时，原来的dp[i+1][j-1]已经被覆盖掉了
     * 所以这里用了pre来记录上一次i的j-1处的结果，即dp[i+1][j-1];
     * <p>
     * 另有一个trick，二维压缩到一维，就看作把矩阵投影到一行即可
     *
     * @param s
     * @return
     */
    public int solution_2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int t, pre;
        for (int i = n - 2; i >= 0; i--) {
            pre = 0;
            for (int j = i + 1; j < n; j++) {
                t = dp[j];
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + 1;
                } else {
                    dp[j] = pre;
                }
                pre = t;
            }
        }
        return dp[n - 1];
    }
}
