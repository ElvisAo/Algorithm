package codetop.哈希表.解数独;

/***
 * leetcode 37
 */
public class Solution {
    /**
     * bland is presented by dot(.)
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9;
        if (i == m) {
            return true;
        }
        if (j == m) {
            return backtrack(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (backtrack(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        int m = 9;
        for (int x = 0; x < m; x++) {
            if (board[i][x] == c) return false;
            if (board[x][j] == c) return false;
            if (board[i / 3 * 3 + x / 3][j / 3 * 3 + x % 3] == c) return false;
        }
        return true;
    }
}
