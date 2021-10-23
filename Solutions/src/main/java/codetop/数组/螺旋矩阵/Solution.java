package codetop.数组.螺旋矩阵;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 54
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> res = new LinkedList<>();
        if (matrix == null) return res;
        int n = matrix.length, m = matrix[0].length;
        if (n == 0 || m == 0) return res;
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (right < left || top > bottom) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
        }
        return res;
    }
}
