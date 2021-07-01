package leetcode.被围绕的区域;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        new UnionFindSolution().solve(board);
        for (char[] line : board) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {    // 处理首尾两列
            if (board[i][0] == 'O') {
                dfs(board, i, 0, visited);
            }
            if (board[i][board[i].length - 1] == 'O') {
                dfs(board, i, board[i].length - 1, visited);
            }
        }
        for (int i = 0; i < board[0].length; i++) {    // 处理首尾两行
            if (board[0][i] == 'O') {
                dfs(board, 0, i, visited);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i, visited);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }


    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || board[i][j] == 'X')
            return;
        board[i][j] = '#';
        visited[i][j] = true;
        dfs(board, i, j - 1, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i + 1, j, visited);

    }
}
