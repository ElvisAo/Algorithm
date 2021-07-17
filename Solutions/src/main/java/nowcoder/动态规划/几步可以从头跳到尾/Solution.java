package nowcoder.动态规划.几步可以从头跳到尾;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 2, 4, 2, 0};
        System.out.println(new Solution().solution_2(A.length, A));
    }

    /**
     * {@动态规划，时间复杂度n^2，超时}
     *
     * @param n
     * @param A
     * @return
     */
    public int solution_1(int n, int[] A) {
        int[] dp = new int[n];  // 状态：当前位置；dp[i]：跳到i的最少步数
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int remote = i + A[i] < n ? i + A[i] : n - 1;
            for (int j = i + 1; j <= remote; j++)
                dp[j] = Math.min(dp[j], dp[i] + 1);
        }
        return dp[n - 1];
    }

    /**
     * {@贪心算法}
     *
     * @param n
     * @param A
     * @return
     */
    public int solution_2(int n, int[] A) {
        // 分别记录：最远位置，跳跃次数，当前位置
        int remote = 0, r = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            remote = Math.max(remote, i + A[i]);    // 记录截止i，能跳到的最远位置
            if (cur >= n) break;
            if (cur == i) {     // 如果i已经遍历到当前位置了，就根据遍历的情况跳到最远位置，并把步数+1
                cur = remote;
                r++;
            }
        }
        return r;
    }
}
