package leetcode.动态规划.不同路径系列.不同路径III;

/**
 * leetcode 980
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new Solution().uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {
        int[] start = new int[2], end = new int[2];
        int step = 0, n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == 0) {
                    step++;
                } else if (grid[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }
        dfs(grid, start, end, step + 1, visited);// 这里+1是加上start点
        return res;
    }

    int res = 0;

    private void dfs(int[][] grid, int[] cur, int[] end, int step, boolean[][] visited) {
        // base case
        if (cur[0] == end[0] && cur[1] == end[1]) {
            if (step == 0) res++;
            return;
        }
        visited[cur[0]][cur[1]] = true;
        int n = grid.length, m = grid[0].length;
        // 四个方向dfs
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < direc.length; i++) {
            int x = cur[0] + direc[i][0];
            int y = cur[1] + direc[i][1];
            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                dfs(grid, new int[]{x, y}, end, step - 1, visited);
            }
        }
        visited[cur[0]][cur[1]] = false;
    }
}
