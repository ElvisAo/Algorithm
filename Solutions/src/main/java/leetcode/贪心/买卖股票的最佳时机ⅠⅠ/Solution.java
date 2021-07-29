package leetcode.贪心.买卖股票的最佳时机ⅠⅠ;

class Solution {
    public int maxProfit(int[] prices) {
        int r = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            int dr = prices[i] - prices[i - 1];
            if (dr > 0) r += dr;
        }
        return r;
    }
}