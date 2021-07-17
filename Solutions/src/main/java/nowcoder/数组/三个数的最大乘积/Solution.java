package nowcoder.数组.三个数的最大乘积;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {-3, -4, 1, 2};
        System.out.println(new Solution().solution_2(a));
    }

    /**
     * {@纯暴力，超时}
     *
     * @param A
     * @return
     */
    public long solution_1(int[] A) {
        int n = A.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (i == k || k == j) continue;
                    max = Math.max(max, 1l * A[i] * A[j] * A[k]);
                }
            }
        }
        return max;
    }

    /**
     * {@先排序}
     *
     * @param A
     * @return
     */
    public long solution_2(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        long m1 = A[0] * A[1] * A[n - 1];
        long m2 = A[n - 1] * A[n - 2] * A[n - 3];
        return Math.max(m1, m2);
    }

}
