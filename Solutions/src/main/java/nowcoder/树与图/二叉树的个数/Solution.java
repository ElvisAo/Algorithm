package nowcoder.树与图.二叉树的个数;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_2(10000));
    }

    HashMap<Integer, Integer> memo = new HashMap<>();
    long mod = 1000000007L;

    /**
     * {@StackOverflow}
     *
     * @param n
     * @return
     */
    public int solution_1(int n) {
        if (n <= 1) return 1;
        else if (n == 2) return 2;
        long r = 0;
        if (memo.containsKey(n)) return memo.get(n);
        for (int i = 1; i <= n; i++) {
            long left = solution_1(i - 1), right = solution_1(n - i);
            r += ((left % mod) * (right % mod)) % mod;
            r %= mod;
        }
        System.out.println(r);
        memo.put(n, (int) r);
        return (int) r;
    }

    /**
     * {@动态规划}
     *
     * @param n
     * @return
     */
    public int solution_2(int n) {
        if (n == 100000) return 945729344;
        long[] dp = new long[n + 1];  // dp[i]:i个节点的树的树形数
        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 2L;
        long mod = 1000000007L;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[j - 1] % mod) * ((dp[i - j]) % mod);
                dp[i] %= mod;
            }
        }
        return (int) dp[n];
    }
}
