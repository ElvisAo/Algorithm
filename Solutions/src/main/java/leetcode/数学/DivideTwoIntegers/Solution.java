package leetcode.数学.DivideTwoIntegers;

/**
 * leetcode 29
 * 不用*、/、%算除法
 */

public class Solution {
    public static void main(String[] args) {
        int a = -2147483648, b = -1;
        System.out.println(new Solution().divide(a, b));
    }

    /**
     * 一个奇怪的点是对最小值的处理，因为取-后还是最小值（溢出）
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        else if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        if (dividend == 0) return 0;
        long a = dividend, b = divisor;
        int sign = 1;
        if ((a > 0 && b > 0) || (a < 0 && b < 0)) sign = 1;
        else sign = -1;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        long res = divi(a, b);
        return sign > 0 ? (int) res : -(int) res;
    }

    /**
     * 让小的数翻倍逼近大数，然后当翻倍后的数大于大的数后，用差进行递归
     *
     * @param a
     * @param b
     * @return
     */
    private long divi(long a, long b) {
        if (a < b) return 0;
        long count = 1, tb = b;
        while ((tb << 1) <= a) {
            count <<= 1;
            tb <<= 1;
        }
        return count + divi(a - tb, b);
    }
}
