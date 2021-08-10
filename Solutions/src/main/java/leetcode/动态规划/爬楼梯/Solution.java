package leetcode.动态规划.爬楼梯;

import java.util.HashMap;

public class Solution {
    /**
     * {@递归超时}
     *
     * @param n
     * @return
     */
    public int solution_1(int n) {
        if (n < 3) return n;
        return solution_1(n - 1) + solution_1(n - 2);
    }


    static HashMap<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 1);
        map.put(2, 2);
    }

    /**
     * {@递归+备忘录}
     *
     * @param n
     * @return
     */
    public int solution_2(int n) {
        if (n < 3) return n;
        if (map.containsKey(n)) return map.get(n);
        int r = solution_1(n - 1) + solution_1(n - 2);
        map.put(n, r);
        return r;
    }

    /**
     * {@动态规划}
     *
     * @param n
     * @return
     */
    public int solution_3(int n) {
        if (n < 3) return n;
        int f = 1, s = 2, t;
        for (int i = 3; i <= n; i++) {
            t = f + s;
            f = s;
            s = t;
        }
        return s;
    }
}
