package leetcode.dfs.岛屿数量;

public class Solution {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int r = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    r++;
                }
            }
        }
        return r;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) return;
        if (grid[i][j] == '1') {
            visited[i][j] = true;
            dfs(grid, i, j - 1, visited);
            dfs(grid, i, j + 1, visited);
            dfs(grid, i - 1, j, visited);
            dfs(grid, i + 1, j, visited);
        }
    }
}
