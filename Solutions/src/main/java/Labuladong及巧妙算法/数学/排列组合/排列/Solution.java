package Labuladong及巧妙算法.数学.排列组合.排列;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().A(5, 2));
    }

    /**
     * A(n,m)计算公式：n!/(n-m)!
     *
     * @param n
     * @param m
     * @return
     */
    public int A(int n, int m) {
        int r = 1;
        for (int i = 0; i < m; i++) {
            r *= n - i;
        }
        return r;
    }
}
