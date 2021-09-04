package Labuladong及巧妙算法.数学.埃氏筛法求质数个数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
    }

    /**
     * 求1~n中质数的个数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] not_prime = new boolean[n];   // 从2~n-1
        int counter = n - 2;    // 去掉一和本身
        for (int i = 2; i < n; i++) {
            if (!not_prime[i]) {
                for (int j = 2; i * j < n; j++) {
                    if (!not_prime[i * j]) {
                        not_prime[i * j] = true;
                        counter--;
                    }
                }
            }
        }
        return counter;
    }
}
