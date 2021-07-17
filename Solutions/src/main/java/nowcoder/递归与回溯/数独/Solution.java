package nowcoder.递归与回溯.数独;

public class Solution {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        int m = 9, n = 9;
        if (row == m) return true;
        if (col == n) {
            return backtrack(board, row + 1, 0);
        }
        if (board[row][col] != '.') return backtrack(board, row, col + 1);
        for (char c = '1'; c <= '9'; c++) {
            if (isLegal(board, row, col, c)) {
                board[row][col] = c;
                boolean b = backtrack(board, row, col + 1);
                if (b) return b;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isLegal(char[][] board, int i, int j, char v) {
        for (int x = 0; x < 9; x++) {
            if (board[x][j] == v) return false;   // 判断列是否重复
            if (board[i][x] == v) return false;   // 判断行是否重复
            if (board[(i / 3) * 3 + x / 3][(j / 3) * 3 + x % 3] == v) return false;
        }
        return true;
    }
}
