/**
 * @author Everett
 * @date 6/30/2021 3:17 PM
 */
package nowcoder.动态规划.丢棋子问题;

import java.util.HashMap;

/**
 * TODO 没有找到满足时空复杂度的解
 * n+1层楼，0<=i<=n，k个棋子。最坏情况下的最少次数
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_4(1000000, 1000000));
    }

    private HashMap<String, Integer> memo = new HashMap<>();


    /**
     * {@栈溢出}
     */
    public int solution_1(int n, int k) {
        if (n < 1 || k < 1) return 0;
        return helper_1(n, k);
    }

    private int helper_1(int n, int k) {
        if (n == 0) return 0;
        if (k == 1) return n;
        String key = n + "" + k;
        if (memo.containsKey(key)) return memo.get(key);
        int r = n + 1;
        for (int i = 1; i <= n; i++) {
            r = Math.min(r, Math.max(helper_1(i - 1, k - 1), helper_1(n - i, k)) + 1);
        }
        memo.put(key, r);
        return r;
    }

    /**
     * {@超时}
     */
    public int solution_2(int n, int k) {
        if (n < 1 || k < 1) return 0;
        return helper_2(n, k);
    }


    private int helper_2(int n, int k) {
        if (n == 0) return 0;
        if (k == 1) return n;
        String key = n + "" + k;
        if (memo.containsKey(key)) return memo.get(key);
        int r = n + 1;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int broken = helper_2(mid - 1, k - 1);
            int not_broken = helper_2(n - mid, k);
            if (broken > not_broken) {
                hi = mid - 1;
                r = Math.min(r, broken + 1);
            } else {
                lo = mid + 1;
                r = Math.min(r, not_broken + 1);
            }
        }
        memo.put(key, r);
        return r;
    }

    /**
     * {@动态规划}
     */
    public int solution_3(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int i = 1; i <= n; i++) {
            /**
             * TODO 为什么下面的循环必须要从2开始处理？从1开始处理就得不到正确答案
             */
            for (int j = 2; j <= k; j++) {
                int min = n + 1;
                for (int c = 1; c <= i; c++) {
                    min = Math.min(min, Math.max(dp[c - 1][j - 1], dp[i - c][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[n][k];
    }

    /**
     * {@动态规划+空间压缩——还是超时}
     */
    public int solution_4(int n, int k) {
        if (n < 1 || k < 1) return 0;
        if (k == 1) return n;
        int[] pre_dp = new int[n + 1];
        int[] cur_dp = new int[n + 1];
        int[] tmp_dp;
        for (int i = 0; i <= n; i++) cur_dp[i] = i;
        /**
         * 为什么这里是<k；而不是<=k？对应上面的j从2开始
         */
        for (int i = 1; i < k; i++) {
            tmp_dp = pre_dp;
            pre_dp = cur_dp;
            cur_dp = tmp_dp;
            for (int j = 1; j <= n; j++) {
                int min = n + 1;
                for (int l = 1; l <= j; l++) {
//                    System.out.println("i=" + i + ", j=" + j + ", l=" + l);
                    min = Math.min(min, Math.max(pre_dp[l - 1], cur_dp[j - l]));
                }
                cur_dp[j] = min + 1;
            }
        }
        return cur_dp[n];
    }
}
