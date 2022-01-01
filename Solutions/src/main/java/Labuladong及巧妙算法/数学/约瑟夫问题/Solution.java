package Labuladong及巧妙算法.数学.约瑟夫问题;

/**
 * 约瑟夫问题的数学解
 */
public class Solution {
    public static void main(String[] args) {
        int n = 5, m = 2;
        System.out.println(solution(n, m));
    }


    public static int solution(int n, int m) {
        if (n == 1) {
            return 1;
        }
        int res = solution(n - 1, m) + m;   // 让新的编号和原来的编号一样，所以需要+m
        res = (res > n) ? (res - n) : res;
        return res;
    }
}
