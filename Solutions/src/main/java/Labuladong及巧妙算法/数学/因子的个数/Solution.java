package Labuladong及巧妙算法.数学.因子的个数;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().countFactor(n));
    }

    /**
     * 如果
     * n = p1^a1*p2^a2...pk^ak;
     * 那么因子个数为
     * (a1+1)*(a2+1)*...*(ak+1)
     *
     * @param n
     * @return
     */
    public int countFactor(int n) {
        int count = 1;
        for (int i = 2; i * i <= n; i++) {  // 只计算一半
            if (n % i == 0) {
                int t = 0;
                while (n % i == 0) {
                    n /= i;
                    t++;
                }
                count *= t + 1;
            }
        }
        if (n > 1) count *= 2;
        return count;
    }
}
