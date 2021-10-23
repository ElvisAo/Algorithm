package codetop.数组.旋转图像;

import java.util.Arrays;

/**
 * leetcode 48
 * 转置+镜像
 * 1. 先对角for(i:0~n) for(j:i~n)
 * 2. 再左右for(i:0~n) for(j:0~n/2)
 */
public class Solution {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution().rotate(arr);
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }   // 对角反转

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }   // 左右反转
    }

    private void swap(int[][] matrix, int i, int j, int j1, int i1) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[j1][i1];
        matrix[j1][i1] = t;
    }
}
