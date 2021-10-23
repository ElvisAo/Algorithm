package codetop.哈希表.最长重复子数组;

/**
 * 类似{@link leetcode.动态规划.最长公共子序列.Solution}
 * leetcode 718
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int r = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                r = Math.max(dp[i][j], r);
            }
        }
        return r;
    }
}
