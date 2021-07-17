package nowcoder.数学.最在公倍数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lcm(2, 6));
    }

    /**
     * lcm = a * b / gcd(a, b)
     *
     * @param a
     * @param b
     * @return
     */
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * {@辗转相除法实际并不是除，而是模}
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (Math.min(a, b) == 0) return Math.max(a, b);
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        return gcd(b % a, a);
    }
}
