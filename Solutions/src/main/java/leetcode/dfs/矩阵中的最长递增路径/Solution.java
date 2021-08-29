package leetcode.dfs.矩阵中的最长递增路径;

public class Solution {
    int[][] memo;   // 备忘录优化提升效率

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        memo = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j] == 0)
                    r = Math.max(r, dfs(matrix, i, j, Integer.MIN_VALUE, visited));
            }
        }
        return r;
    }

    int r = 0;

    private int dfs(int[][] matrix, int i, int j, int preVal, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] <= preVal) {
            return 0;
        }
        if (memo[i][j] != 0) return 1 + memo[i][j];
        visited[i][j] = true;
        int top = dfs(matrix, i - 1, j, matrix[i][j], visited);
        int right = dfs(matrix, i, j + 1, matrix[i][j], visited);
        int down = dfs(matrix, i + 1, j, matrix[i][j], visited);
        int left = dfs(matrix, i, j - 1, matrix[i][j], visited);
        int longest = Math.max(Math.max(top, down), Math.max(left, right));
        memo[i][j] = longest;
        visited[i][j] = false;
        return 1 + longest;
    }
}
