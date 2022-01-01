package leetcode.dfs.IslandProblem.岛屿数量;

/***
 * leetcode 200
 */
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

    public int solution_2(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';   // floodfill，避免使用visited[][]
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int k = 0; k < 4; k++) {
            int next_i = i + dirs[k][0];
            int next_j = j + dirs[k][1];
            dfs(grid, next_i, next_j);
        }
    }
}
