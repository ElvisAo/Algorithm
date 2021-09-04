package leetcode.动态规划.买卖股票的最佳时机.一次;

import java.util.LinkedList;

/**
 * leetcode 121
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 两层循环暴力：超时
     *
     * @param prices
     * @return
     */
    public int solution_1(int[] prices) {
        int n = prices.length, r = 0;
        int minVal = prices[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (r < prices[i] - prices[j])
                    r = prices[i] - prices[j];
            }
        }
        return r;
    }

    /**
     * 单调栈
     *
     * @param prices
     * @return
     */
    public int solution_2(int[] prices) {
        int n = prices.length;
        LinkedList<Integer> left = new LinkedList<>();  // 记录左边最小的元素
        int[] minLeft = new int[n];
        LinkedList<Integer> right = new LinkedList<>(); // 记录右边最大的元素
        int[] maxRight = new int[n];

        for (int i = 0; i < n; i++) {
            while (!left.isEmpty() && left.peekLast() >= prices[i]) left.pollLast();
            left.addLast(prices[i]);
            minLeft[i] = left.peekFirst();

            int j = n - i - 1;
            while (!right.isEmpty() && right.peekLast() <= prices[j]) right.pollLast();
            right.addLast(prices[j]);
            maxRight[j] = right.peekFirst();
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = Math.max(maxRight[i] - minLeft[i], r);
        }
        return r;
    }

    /**
     * 用min记录前面最小的数
     *
     * @param prices
     * @return
     */
    public int solution_3(int[] prices) {
        int min = Integer.MAX_VALUE, r = 0, n = prices.length;
        for (int i = 0; i < n; i++) {
            if (min > prices[i]) min = prices[i];
            r = Math.max(r, prices[i] - min);
        }
        return r;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int solution_4(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);  // 注意：这里不能是Math.max(dp[i-1][0]-prices[i], dp[i-1][1])
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 动态规划+空间压缩
     *
     * @param prices
     * @return
     */
    public int solution_5(int[] prices) {
        int n = prices.length;
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(-prices[i], dp_1);
        }
        return dp_0;
    }
}
