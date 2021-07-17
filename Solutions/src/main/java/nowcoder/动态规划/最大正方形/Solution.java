package nowcoder.动态规划.最大正方形;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution_1(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++)
            if (matrix[i][0] == '1') dp[i][0] = 1;
        for (int j = 0; j < col; j++)
            if (matrix[0][j] == '1') dp[0][j] = 1;
        int r = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][j]=='1')
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                r = Math.max(r, dp[i][j]);
            }
        }
        return r*r;
    }
}
