package leetcode.模拟.最大矩形;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        char[][] matrix = {
                {'0', '0', '1'},
                {'1', '1', '1'}
        };
        System.out.println(new Exercise().solution_1(matrix));
    }

    public int solution_1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] left = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
            }
        }
        int r = 0, width, area;
//        for(int i=0; i<n; i++) System.out.println(Arrays.toString(left[i]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') continue;
                width = left[i][j];
                area = width;
                for (int k = i; k >= 0 && left[k][j] != 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(width * (i - k + 1), area);
                }
                r = r > area ? r : area;
            }
        }
        return r;
    }
}
