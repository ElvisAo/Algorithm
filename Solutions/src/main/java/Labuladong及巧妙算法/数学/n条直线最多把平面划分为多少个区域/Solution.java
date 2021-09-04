package Labuladong及巧妙算法.数学.n条直线最多把平面划分为多少个区域;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve(4));
    }

    public int solve(int n) {
        if (n == 0) return 1;
        return n + solve(n - 1);
    }
}
