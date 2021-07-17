package nowcoder.递归与回溯.N皇后问题;

/**
 * {@关键点在于按行回溯，按列选择}
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().Nqueen(8));
    }

    static int r;

    public int Nqueen(int n) {
        int[][] board = new int[n][n];
        backtrack(board, 0);
        return r;
    }

    private void backtrack(int[][] board, int row) {
        if (row == board.length) {
            r++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!isLegal(board, row, i)) continue;
            board[row][i] = 1;
            backtrack(board, row + 1);
            board[row][i] = 0;
        }
    }

    // 因为上面的回溯是在列中做选择，所以不用考虑同一行上的重复
    private boolean isLegal(int[][] board, int i, int j) {
        for (int x = 0; x < i; x++) // 列上是否重复
            if (board[x][j] == 1) return false;
        for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--)  // 左上角
            if (board[x][y] == 1) return false;
        for (int x = i - 1, y = j + 1; x >= 0 && y < board.length; x--, y++)    // 右上角
            if (board[x][y] == 1) return false;
        return true;
    }
}
