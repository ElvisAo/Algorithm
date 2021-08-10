package leetcode.模拟.最大矩形;

/**
 * 据说和{@link leetcode.模拟.柱状图中的最大矩形.Solution}很像，可以用该题的思想
 */
public class Solution {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new Solution().solution_1(matrix));
    }

    /**
     * {@暴力法，枚举所有可能矩形的左上、右下角，并判断该矩形是否合法}
     *
     * @param matrix
     * @return
     */
    public int solution_1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int r = 0, area;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') continue;
                for (int x = i + 1; x < n; x++) {
                    for (int y = j + 1; y < m; y++) {
                        if (matrix[x][y] == '0') continue;
                        if (isRectangle(matrix, i, j, x, y)) {
                            area = (x - i + 1) * (y - j + 1);
                            r = r > area ? r : area;
                        }
                    }
                }
            }
        }
        return r;
    }

    private boolean isRectangle(char[][] matrix, int i1, int j1, int i, int j) {
        for (int t = i1; t <= i; t++) {
            for (int l = j1; l <= j; l++) {
                if (matrix[t][l] == '0') return false;
            }
        }
        return true;
    }

    /**
     * 用left[i][j]记录i,j位置前面（同一行）连续1的个数
     * 然后从第i行j列往上找1，不断更新
     *
     * @param matrix
     * @return
     */
    public int solution_2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];   // 记录i,j位置前面连续1的个数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {  // 枚举每个不为0的位置
                    continue;
                }
                int width = left[i][j];     // 以前面连续1的个数为宽
                int area = width;
                for (int k = i - 1; k >= 0; k--) {      // 以往上找的、为1的行数为高
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
