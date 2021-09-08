package leetcode.动态规划.整数拆分;

import java.util.Arrays;

/**
 * leetcode 343
 */
public class Solution {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().solution_2(n));
    }

    /**
     * 参考别人的
     *
     * @param n
     * @return
     */
    public int solution_1(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[n + 1];  // 状态：dp[i]：i可以划分为的最大乘积
        Arrays.fill(dp, 1);
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            cur = dp[n];
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] * i);
            }
        }
        return cur;
    }

    /**
     * 个人习惯，在外层控制dp[i]，内层循环用来更新dp[i]的值
     *
     * @param n
     * @return
     */
    public int solution_2(int n) {
        int[] dp = new int[n + 1];  // dp[i]：i的最大划分乘积
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp, 1);
        }
        for (int i = 2; i <= n; i++) {
            // 因为从0开始，就导致了数i不拆分的情况
            // 从1开始就是必须拆分
            for (int j = 1; j < i; j++) {   // j<j确保了i-j>0。这里从0开始就会导致dp[0]*(2-0) > dp[1]*1
                // 取max的时候主要要考虑j*(i-j)，即只拆分两个数的情况，比如i==4,dp[i]应该为4，此时j==2，但是由于dp[2]==1，所以dp[j]*(i-j)==2，而不是2*(4-2)==4
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }
}
