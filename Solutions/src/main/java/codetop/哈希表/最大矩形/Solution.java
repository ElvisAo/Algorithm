package codetop.哈希表.最大矩形;

/***
 * leetcode 85
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length, res = -1;
        int[][] width = new int[n + 1][m + 1];  // sotred the number of successive one
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    width[i][j] = width[i][j - 1] + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int w = width[i][j], a = w;
                if (width[i][j] != 0) {
                    for (int k = i - 1; k >= 0 && width[k][j] != 0; k--) {
                        w = Math.min(w, width[k][j]);
                        a = Math.max(a, (i - k + 1) * w);
                    }
                }
                res = Math.max(res, a);
            }
        }
        return res;
    }
}
