package 旷视.nm问题;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(14, 3));
    }

    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int solution(int n, int m) {
        LinkedList<Integer> three = new LinkedList<>();
        LinkedList<Integer> seven = new LinkedList<>();
        for (int i = 3, j = 1; i * j < n; j++) three.addLast(i * j);
        for (int i = 7, j = 1; i * j <= n; j++) seven.addLast(i * j);
        int r = 0, ln;
        for (int i = 0; i < three.size(); i++) {
            for (int j = 0; j < seven.size(); j++) {
                if (seven.get(j) - three.get(i) >= m - 2) {
                    ln = seven.get(j) - three.get(i) - 1;
                    if (memo.containsKey(ln)) {
                        r += memo.get(ln);
                    } else {
                        int t = help(ln, m - 2);
                        memo.put(ln, t);
                        r += t;
                    }
                }
            }
        }
        return r;
    }

    // n个里面选m个
    private int help(int n, int m) {
        double temp = 1;
        for (int i = 0; i < n - m; ++i) {   // 分子从m+1开始往上乘（n-m）个数；分母为(n-m)的阶乘
            temp *= m + i + 1;
            temp /= i + 1;
        }

        return (int) temp;
    }
}
