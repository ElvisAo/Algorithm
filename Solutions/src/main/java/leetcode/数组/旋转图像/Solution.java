package leetcode.数组.旋转图像;

public class Solution {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int col = n - 1 - i;
                int row = j;
                t[row][col] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            matrix[i] = t[i];
        }
    }
}
