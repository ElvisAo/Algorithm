package nowcoder.history.华为.数独;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = 9;
        int[][] board = new int[base][base];
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < base; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        backtrack(board, 0, 0);
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print(board[i][j]);
                if (j != base - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean backtrack(int[][] board, int row, int col) {
        int base = 9;
        if (row == base) return true;
        if (col == base) return backtrack(board, row + 1, 0);
        if (board[row][col] != 0) return backtrack(board, row, col + 1);
        for (int num = 1; num <= base; num++) {
            if (!isLegal(board, row, col, num)) continue;
            board[row][col] = num;
            if (backtrack(board, row, col + 1)) return true;
            board[row][col] = 0;
        }
        return false;
    }

    private static boolean isLegal(int[][] board, int row, int col, int target) {
        int base = 9;
        for (int i = 0; i < base; i++) {
            if (board[row][i] == target) return false;
            if (board[i][col] == target) return false;
        }
        for (int r = 3 * (row / 3); r < 3 * (row / 3) + 3; r++) {
            for (int c = 3 * (col / 3); c < 3 * (col / 3) + 3; c++) {
                if (board[r][c] == target) return false;
            }
        }
        return true;
    }
}
