package nowcoder.模拟.螺旋矩阵;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new Solution().spiralOrder(array));
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length - 1, m = matrix[0].length - 1;
        int top = 0, right = m, bottom = n, left = 0;
        ArrayList<Integer> list = new ArrayList<>((n + 1) * (m + 1));
        while (top <= bottom && left <= right) {
            // 上面
            for (int i = left; i <= right; i++) list.add(matrix[top][i]);
            top++;
            if (top > bottom) break;
            // 右边
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
            right--;
            if (left > right) break;
            // 下面
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            bottom--;
            if (top > bottom) break;
            // 左边
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
            left++;
            if (left > right) break;
        }
        return list;
    }
}
