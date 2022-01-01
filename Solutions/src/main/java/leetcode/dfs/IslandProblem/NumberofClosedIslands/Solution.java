package leetcode.dfs.IslandProblem.NumberofClosedIslands;

/**
 * leetcode 1254
 */
public class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) dfs(grid, 0, i);
        for (int i = 0; i < n; i++) dfs(grid, i, 0);
        for (int i = 0; i < m; i++) dfs(grid, n - 1, i);
        for (int i = 0; i < n; i++) dfs(grid, i, m - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 1) return;
        grid[i][j] = 1;   // floodfill，避免使用visited[][]
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int next_i = i + dirs[k][0];
            int next_j = j + dirs[k][1];
            dfs(grid, next_i, next_j);
        }
    }

}
