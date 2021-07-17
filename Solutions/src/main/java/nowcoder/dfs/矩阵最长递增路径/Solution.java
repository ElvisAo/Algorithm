package nowcoder.dfs.矩阵最长递增路径;

public class Solution {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().solve(m));
    }

    public int solve(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(matrix, i, j, 1, visited);
            }
        }
        return rt;
    }

    int rt;

    private void dfs(int[][] matrix, int i, int j, int path, boolean[][] visited) {
        visited[i][j] = true;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            rt = Math.max(rt, path + 1);
            dfs(matrix, i - 1, j, path + 1, visited);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            rt = Math.max(rt, path + 1);
            dfs(matrix, i, j + 1, path + 1, visited);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            rt = Math.max(rt, path + 1);
            dfs(matrix, i + 1, j, path + 1, visited);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            rt = Math.max(rt, path + 1);
            dfs(matrix, i, j - 1, path + 1, visited);
        }
        visited[i][j] = false;
    }
}
