package 解数独;

import java.util.Arrays;

public class Solution {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9;
        if (j == m) {
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            return true;
        }
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isLegal(board, i, j, c)) {
                board[i][j] = c;
                if (backtrack(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isLegal(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
            if (board[k][j] == c) return false;
            if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
