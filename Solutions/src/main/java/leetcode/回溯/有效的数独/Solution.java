package leetcode.回溯.有效的数独;

/***
 * leetcode 36
 * 空格用.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] row = new boolean[n][n]; // row[i][x]：第i行，x出现了没有
        boolean[][] col = new boolean[n][n]; // col[j][x]：第j列，x出现了没有
        boolean[][] block = new boolean[n][n];    // nine[k][x]：第k个3*3的块，x出现了没有

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                // 如何把i行j列转换到第几个3*3的块？i/3*3，大的第几行，j/3大的第几列。i/3*3+j/3即第几个3*3的块
                if (row[i][c] || col[j][c] || block[i / 3 * 3 + j / 3][c]) return false;
                row[i][c] = true;
                col[j][c] = true;
                block[i / 3 * 3 + j / 3][c] = true;
            }
        }
        return true;
    }
}
