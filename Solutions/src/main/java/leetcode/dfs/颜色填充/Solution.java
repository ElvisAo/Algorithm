package leetcode.dfs.颜色填充;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] res = new Solution().floodFill(image, 1, 1, 2);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origin = image[sr][sc];
        dfs(image, sr, sc, newColor, origin);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int origin) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] != origin || image[i][j] == -1)
            return;
        image[i][j] = -1;
        dfs(image, i - 1, j, newColor, origin);
        dfs(image, i + 1, j, newColor, origin);
        dfs(image, i, j - 1, newColor, origin);
        dfs(image, i, j + 1, newColor, origin);
        image[i][j] = newColor;
    }
}
