package Labuladong及巧妙算法.数学.公因数公倍数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().gcd(12, 8));
        System.out.println(new Solution().lcm(12, 8));
    }

    /**
     * 最大公因数
     *
     * @param a 较大数
     * @param b 较小数
     * @return 最大公因数
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 最小公倍数
     *
     * @param a 较大数
     * @param b 较小数
     * @return 最小公倍数
     */
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
