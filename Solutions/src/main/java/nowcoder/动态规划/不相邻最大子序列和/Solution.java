package nowcoder.动态规划.不相邻最大子序列和;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(new Solution().solution_2(3, array));
    }

    /**
     * {@超时}
     *
     * @param n
     * @param array
     * @return
     */
    public long solution_1(int n, int[] array) {
        long[] dp = new long[n];
        long tmax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = array[i];
            for (int j = 0; j < i - 1; j++) {
                tmax = Math.max(dp[j], tmax);
            }
            dp[i] = Math.max(dp[i], dp[i] + tmax);
            tmax = Integer.MIN_VALUE;
        }
        return dp[n - 1];
    }

    /**
     * {@打家劫舍问题}
     *
     * @param n
     * @param array
     * @return
     */
    public long solution_2(int n, int[] array) {
        int[] dp = new int[n];  // dp[i]：到index i为止，最大序列和
        dp[0] = array[0];
        if (n == 1) return dp[0];
        dp[1] = Math.max(array[0], array[1]);
        if (n == 2) return dp[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
        }
        return dp[n - 1];
    }

    /**
     * {@打家劫舍+空间优化}
     *
     * @param n
     * @param array
     * @return
     */
    public long solution_3(int n, int[] array) {
        if (n == 1) return array[0];
        if (n == 2) return Math.max(array[0], array[1]);
        long cur = 0, pre1 = array[1], pre2 = array[0];
        for (int i = 2; i < n; i++) {
            cur = Math.max(pre1, pre2 + array[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
