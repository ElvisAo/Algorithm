package leetcode.模拟.螺旋矩阵系列.螺旋矩阵II;

import java.util.Arrays;

/**
 * leetcode 59
 */
public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = new Solution().generateMatrix(n);
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;   // c：要填充的数，j相当于用来控制转了几圈
        while (c <= n * n) {
            for (int i = j; i < n - j; i++) // i变：用j控制行号，i控制列号
                arr[j][i] = c++;
            for (int i = j + 1; i < n - j; i++)     // i变：用i控制行号，j控制列号
                arr[i][n - j - 1] = c++;
            for (int i = n - j - 2; i >= j; i--)    // i变：用i控制列号，j控制行号
                arr[n - j - 1][i] = c++;
            for (int i = n - j - 2; i > j; i--)     // i变：用i控制行号，j控制列号
                arr[i][j] = c++;
            j++;
        }
        return arr;
    }
}
