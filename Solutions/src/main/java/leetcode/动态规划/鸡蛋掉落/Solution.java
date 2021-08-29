package leetcode.动态规划.鸡蛋掉落;

import java.util.HashMap;

class Solution {
    HashMap<String, Integer> memo = new HashMap<>();

    /**
     * 备忘录减枝
     *
     * @param k
     * @param n
     * @return
     */
    public int solution_1(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;
        int r = n + 1;
        String key = k + "" + n;
        if (memo.containsKey(key)) return memo.get(key);
        for (int i = 1; i <= n; i++) {
            r = Math.min(r, Math.max(solution_1(k, n - i), solution_1(k - 1, i - 1)) + 1);
        }
        memo.put(key, r);
        return r;
    }

    /**
     * 二分法减枝
     *
     * @param k
     * @param n
     * @return
     */
    public int solution_2(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;
        int r = n + 1;
        String key = k + "" + n;
        if (memo.containsKey(key)) return memo.get(key);
        // 固定K和N，视左作关于i的函数，则superEggDrop(k,n-i)是关于i递增的函数，superEggDrop(k-1,i-1)是关于i递减的函数，那么就可以使用二分法来找最优点
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int not_broken = solution_2(k, n - mid);    // 没碎
            int broken = solution_2(k - 1, mid - 1);
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
     * 改变dp数组的定义。
     * {@确定当前的鸡蛋个数和最多允许的扔鸡蛋次数，就可以确定最高的楼层数}
     *
     * @param k
     * @param n
     * @return
     */
    public int solution_3(int k, int n) {
        // dp[k][m]：当前有k个鸡蛋，可以尝试扔m次，最多能够确定测试的一栋楼的高度
        int[][] dp = new int[k + 1][n + 1];
        int m = 0;
        while (dp[k][m] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;     // 因为只依赖本行和前一行，还可以空间压缩
            }
        }
        return m;
    }
}
