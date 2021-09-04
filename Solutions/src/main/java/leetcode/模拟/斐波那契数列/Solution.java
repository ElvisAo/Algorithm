package leetcode.模拟.斐波那契数列;

public class Solution {
    /**
     * 注意为什么能在这里取模
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) return n;
        int f = 0, s = 1;
        for (int i = 2; i <= n; i++) {
            int t = s;
            s = (f + s) % 1000000007;
            f = t;
        }
        return s;
    }
}
