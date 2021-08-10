package leetcode.回溯.单词搜索;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, i, j, word, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
        if (board[i][j] == word.charAt(k)) {
            visited[i][j] = true;
            boolean up = backtrack(board, i - 1, j, word, k + 1, visited);
            boolean right = backtrack(board, i, j + 1, word, k + 1, visited);
            boolean bottom = backtrack(board, i + 1, j, word, k + 1, visited);
            boolean left = backtrack(board, i, j - 1, word, k + 1, visited);
            visited[i][j] = false;
            return up || right || bottom || left;
        }
        return false;
    }
}
