package leetcode.位运算.比特位计数;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(new Solution().solution_1(n)));
    }

    public int[] solution_1(int n) {
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) r[i] = countOne(i);
        return r;
    }

    public int countOne(int n) {
        int mask = 1;
        int ones = 0;
        while (n > 0) {
            ones += (n & mask) == 1 ? 1 : 0;
            n >>= 1;
        }
        return ones;
    }

    public int[] solution_2(int n) {
        int[] r = new int[n + 1];
        for (int i = 1; i <= n; i++) {  // i>>1比i小，所以在之前已经计算过了
            r[i] = r[i >> 1] + (i & 1);
        }
        return r;
    }
}
