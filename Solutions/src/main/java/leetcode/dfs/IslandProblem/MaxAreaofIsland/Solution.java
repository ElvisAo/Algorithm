package leetcode.dfs.IslandProblem.MaxAreaofIsland;

/**
 * leetcode 695
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j, 0));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int area) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return 0;
        area++;
        grid[i][j] = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int next_i = dirs[k][0] + i, next_j = dirs[k][1] + j;
            area += dfs(grid, next_i, next_j, 0);
        }
        return area;
    }
}
