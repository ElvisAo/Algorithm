package leetcode.模拟.螺旋矩阵系列.螺旋矩阵II;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int[][] arr = new Exercise().generateMatrix(3);
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int num = 1, circle = 0;
        while (num <= n * n) {
            for (int i = circle; i < n - circle; i++) {   // 行
                arr[circle][i] = num++;
            }
            for (int i = circle + 1; i < n - circle; i++) { // 列
                arr[i][n - circle - 1] = num++;
            }
            for (int i = n - circle - 2; i >= circle; i--) {  // 行，为什么-2？因为最后的那列已经填充了数字
                arr[n - circle - 1][i] = num++;
            }
            for (int i = n - circle - 2; i > circle; i--) {  // 列
                arr[i][circle] = num++;
            }
            circle++;
        }
        return arr;
    }
}
