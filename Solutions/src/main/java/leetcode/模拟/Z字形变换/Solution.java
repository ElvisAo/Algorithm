package leetcode.模拟.Z字形变换;

/**
 * TODO 有优化空间
 */
public class Solution {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        System.out.println(new Solution().convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = s.length();
        char[][] array = new char[numRows][n];
        int direc = 1;  // 1表示往下，-1表示往上
        int cur_row = 0;    // 当前所在行
        int cur_col = 0;    // 当前所在列
        for (int i = 0; i < n; i++) {
            if (direc == 1) {   // 在往下走
                array[cur_row++][cur_col] = s.charAt(i);
                if (cur_row == numRows) {
                    cur_row -= 2;
                    cur_col += 1;
                    direc = -1;
                }
            } else {    // 在往上走
                array[cur_row--][cur_col++] = s.charAt(i);
                if (cur_row == -1) {
                    cur_row += 2;
                    direc = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] != 0) sb.append(array[i][j]);
            }
        }
        return sb.toString();
    }
}
