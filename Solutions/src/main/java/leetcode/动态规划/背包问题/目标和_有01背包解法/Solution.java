package leetcode.动态规划.背包问题.目标和_有01背包解法;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new Solution().solution_3(nums, target));
    }

    static class R {
        int r;

        public R(int r) {
            this.r = r;
        }
    }

    /**
     * {@回溯法（纯暴力）}
     */
    public int solution_1(int[] nums, int S) {
        R r = new R(0);
        helper1(nums, S, 0, 0, r);
        return r.r;
    }

    /**
     * {@暴力-这里的这种写法没法优化，甚至无法使用memo，如果要能够使用备忘录，结果应该返回，而不是使用全局变量}
     */
    private void helper1(int[] nums, int S, int i, int now, R r) {
        if (i == nums.length) {
            if (now == S) r.r++;
            return;
        }
        helper1(nums, S, i + 1, now + nums[i], r);  // 如果用+
        helper1(nums, S, i + 1, now - nums[i], r);  // 如果用-
    }

    /**
     * {@回溯法（备忘录优化）}
     *
     * @param nums
     * @param S
     * @return
     */
    public int solution_2(int[] nums, int S) {
        return helper2(nums, S, nums.length - 1);
    }

    private HashMap<String, Integer> memo = new HashMap<>();

    private int helper2(int[] nums, int rema, int i) {
        if (i == -1) {
            if (rema == 0) return 1;
            return 0;
        }
        String k = i + "[" + rema + "]";
        if (memo.containsKey(k)) return memo.get(k);
        int add = helper2(nums, rema + nums[i], i - 1);
        int sub = helper2(nums, rema - nums[i], i - 1);
        int v = add + sub;
        memo.put(k, v);
        return v;
    }

    /**
     * {@动态规划（背包问题）}
     * {@动态规划：注意循环中j可以为0，因为r能取到0。思路：要选k个+，v个-，那么考虑所有的和，然后对于做-的部分，就应该减去双倍。那么问题就变成了应该找出x个数，使这x个数的和为应该减去的值}
     */
    public int solution_3(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        int r = sum - S;
        if (r < 0 || r % 2 == 1) return 0;
        return helper3(nums, r / 2);
    }

    /**
     * {@在nums中选k个数来凑成r}
     */
    private int helper3(int[] nums, int r) {
        int ln = nums.length;
        int[][] dp = new int[ln + 1][r + 1];
        for (int i = 0; i <= ln; i++) dp[i][0] = 1;
        for (int i = 1; i <= ln; i++) {
            for (int j = 0; j <= r; j++) {  // 这里要能取到0，因为r可能为0
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[ln][r];
    }
}