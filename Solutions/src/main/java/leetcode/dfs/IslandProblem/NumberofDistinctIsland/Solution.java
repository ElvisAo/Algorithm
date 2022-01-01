package leetcode.dfs.IslandProblem.NumberofDistinctIsland;

import java.util.HashSet;

/**
 * leetcode 492 vip
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1},
        };
        System.out.println(new Solution().numDistinctIslands(grid));
    }

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 888);   // the initial dirction is arbitrary
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int direction) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(direction).append(',');
        dfs(grid, i - 1, j, sb, 1);
        dfs(grid, i + 1, j, sb, 2);
        dfs(grid, i, j - 1, sb, 3);
        dfs(grid, i, j + 1, sb, 4);
    }
}
