package nowcoder.模拟.矩阵乘法;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 2}}, b = {{3, 4}, {2, 1}};
        int[][] r = new Solution().solution_1(a, b);
        for (int i = 0; i < r.length; i++) System.out.println(Arrays.toString(r[i]));
    }

    public int[][] solution_1(int[][] a, int[][] b) {
        int n = a.length;
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int m = 0;
                for (int k = 0; k < n; k++) {
                    m += a[i][k] * b[k][j];
                }
                r[i][j] = m;
            }
        }
        return r;
    }
}
