package leetcode.最后一块石头的重量II_有01背包解法;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_2(new int[]{2, 7, 4, 1, 8, 1}));
    }

    static class R {
        int r;

        public R(int r) {
            this.r = r;
        }
    }

    /**
     * {@暴力递归}
     */
    public int solution_1(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>(stones.length);
        R r = new R(Integer.MAX_VALUE);
        Arrays.stream(stones).forEach(x -> list.add(x));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) helper1(new ArrayList<>(list), r, i, j);
            }
        }
        return r.r;
    }

    private void helper1(ArrayList<Integer> list, R r, int i, int j) {
        Integer elei = list.get(i);
        Integer elej = list.get(j);
        list.remove(elei);
        list.remove(elej);
        if (elei.intValue() != elej.intValue()) list.add(Math.abs(elei - elej));
        if (list.size() == 1) r.r = Math.min(r.r, list.get(0));
        for (int x = 0; x < list.size(); x++) {
            for (int y = 0; y < list.size(); y++) {
                if (x != y) helper1(new ArrayList<>(list), r, x, y);
            }
        }
    }

    /**
     * {@01背包：转换为两堆石头的最小差值，求sum/2容量的背包最多能装多重的石头}
     */
    public int solution_2(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        // 01背包
        int ln = stones.length;
        int[][] dp = new int[ln + 1][target + 1];
        for (int i = 1; i <= ln; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - stones[i - 1] >= 0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return sum - 2 * dp[ln][target];
    }

    /**
     * {@01背包+空间优化}
     */
    public int solution_3(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        // 01背包
        int ln = stones.length;
        int[] dp = new int[target + 1];
        for (int i = 1; i <= ln; i++) {
            for (int j = target; j >= 0; j--) {
                if (j - stones[i - 1] >= 0) dp[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
            }
        }
        return sum - 2 * dp[target];
    }
}
