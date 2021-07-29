package leetcode.回溯.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(1);
        for (List list : lists) System.out.println(list);
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] line : board) {
            Arrays.fill(line, '.');
        }
        List<List<String>> olist = new ArrayList<>();
        boolean[] col = new boolean[n], ldiag = new boolean[2 * n], rdiag = new boolean[2 * n];     // 本来应该是2*n-1，但是为了避免rdiag中的row+i+1在1时越界，所以多1
        backtrack(board, 0, col, ldiag, rdiag, olist);
        return olist;
    }

    private void backtrack(char[][] board, int row, boolean[] column, boolean[] ldiag, boolean[] rdiag, List<List<String>> olist) {
        int n = board.length;
        if (row == n) {
            List<String> ilist = new LinkedList<>();
            for (char[] line : board) {
                ilist.add(new String(line));
            }
            olist.add(ilist);
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(String.format("n=%d row=%d, i=%d", n, row, i));
                if (!column[i] && !ldiag[n - row + i - 1] && !rdiag[row + i + 1]) {
                    column[i] = ldiag[n - row + i - 1] = rdiag[row + i + 1] = true;
                    board[row][i] = 'Q';
                    backtrack(board, row + 1, column, ldiag, rdiag, olist);
                    board[row][i] = '.';
                    column[i] = ldiag[n - row + i - 1] = rdiag[row + i + 1] = false;
                }
            }
        }
    }
}