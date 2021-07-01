package nowcoder.顺时针旋转矩阵;

public class Solution {
    public int[][] rotateMatrix(int[][] mat, int n) {
        int[][] nmat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nmat[j][n - i - 1] = mat[i][j];
            }
        }
        return nmat;
    }
}
