package leetcode.数学.阶乘后的零;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 思路：0来源与2*5，因此可以把阶乘的元素拆成质数相乘，看里面有多少个2与5，同时，显示5的个数应该小于2的个数，所以只看5的个数即可
     * n! = n * (n-1) * (n-2) * (n-3) *...* 1，记每个元素为K_i
     * K_i = prime_1 * prime_2 * prime_3 *...* prime_n  // 看这里面有没有质数5。（因为5的倍数已经不是质数，所以不考虑），如果有5就有一个0
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    /**
     * 非递归写法
     *
     * @param n
     * @return
     */
    public int notRecursion(int n) {
        int r = 0;
        while (n > 0) {
            r += n / 5;
            n /= 5;
        }
        return r;
    }
}
