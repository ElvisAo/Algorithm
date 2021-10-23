package leetcode.二分.ArrangeCoins;

/**
 * leetcode 441
 */
class Solution {
    public static void main(String[] args) {
        int n = 1804289383;
        System.out.println(new Solution().arrangeCoins_2(n));
    }

    public int arrangeCoins(int n) {
        int res = 0;
        for (int i = 1; n - i >= 0; i++) {
            res++;
            n -= i;
        }
        return res;
    }

    public int arrangeCoins_2(int n) {
        int lo = 1, hi = n, res = n;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;   // +1是为了让取值靠右，避免lo=mid引起的死循环
            long sum = (1 + mid) * ((long) mid) / 2;
            if (sum <= n) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
