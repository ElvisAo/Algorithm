package Labuladong及巧妙算法.动态规划.一到n的二进制中1出现的次数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_1(4));
    }

    private int solution_1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int mast = 1;
        int r = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i >> 1] + ((i & mast) == 1 ? 1 : 0);
            r += dp[i];
        }
        return r;
    }
}
