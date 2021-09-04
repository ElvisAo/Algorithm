package leetcode.模拟.螺旋矩阵系列.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 54
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> r = new Solution().spiralOrder(arr);
        System.out.println(r);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> r = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return r;
        int n = matrix.length, m = matrix[0].length;
        int circle = 0, counter = 1;
        while (counter <= n * m) {
            //上面行
            for (int i = circle; i < m - circle; i++, counter++)
                r.add(matrix[circle][i]);  // if n = 3, m = 4, circle = 1: i from 1 to 3(can be reached)
            // 右边列
            for (int i = circle + 1; i < n - circle; i++, counter++)
                r.add(matrix[i][m - circle - 1]);   // if circle = 1: i from 2 to 1，which mean this loop invalid
            // 下面行
            // if circle = 1: i from 1 to 1, so, as the input from 2 to 12 of dismension(3,4)，the num of 6 could reached, while it isn't，
            // so, use the circle < n/2 to limit it to avoid extra repeat
            for (int i = m - circle - 2; i >= circle && circle < n / 2; i--, counter++)
                r.add(matrix[n - circle - 1][i]);
            // 左边列
            // the statement of circle < m/2 limte the repeat of only one column
            for (int i = n - circle - 2; i > circle && circle < m / 2; i--, counter++)
                r.add(matrix[i][circle]);
            circle++;
        }
        return r;
    }
}
