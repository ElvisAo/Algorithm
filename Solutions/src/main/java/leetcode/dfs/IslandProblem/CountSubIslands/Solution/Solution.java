package leetcode.dfs.IslandProblem.CountSubIslands.Solution;

/**
 * leetcode 1905
 */
public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length, m = grid1[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int next_i = i + dirs[k][0];
            int next_j = j + dirs[k][1];
            dfs(grid, next_i, next_j);
        }
    }
}
