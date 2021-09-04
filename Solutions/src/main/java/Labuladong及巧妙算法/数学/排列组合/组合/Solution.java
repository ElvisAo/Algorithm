package Labuladong及巧妙算法.数学.排列组合.组合;

public class Solution {
    public static void main(String[] args) {

    }

    /**
     * C(n,m):n个里面选m个
     * 计算公式：n!/[(n-m)!*m!]
     *
     * @param n
     * @param m
     * @return
     */
    private int C(int n, int m) {
        double temp = 1;
        for (int i = 0; i < n - m; ++i) {
            temp *= m + i + 1;  // 分子从m+1开始乘n-m个数
            temp /= i + 1;      // 分母为（n-m)的阶乘——刚好也是n-m个数
        }
        return (int) temp;
    }
}
