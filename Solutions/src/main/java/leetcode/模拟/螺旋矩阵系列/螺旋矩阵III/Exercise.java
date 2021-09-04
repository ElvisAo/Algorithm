package leetcode.模拟.螺旋矩阵系列.螺旋矩阵III;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        int R = 5, C = 6, r0 = 1, c0 = 4;
        int[][] r = new Exercise().spiralMatrixIII(R, C, r0, c0);
        for (int[] line : r) System.out.println(Arrays.toString(line));
    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] r = new int[rows * cols][2];
        int[][] circle = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 当前点的可选的移动方向
        int direc = 0;  // 当前移动方向，0：右，1：下，2：左，3：上
        int x = rStart, y = cStart, counter = 1;    // 当前坐标与计数器
        int top = rStart - 1, right = cStart + 1, bottom = rStart + 1, left = cStart - 1;
        while (counter <= rows * cols) {
            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                r[counter - 1] = new int[]{x, y};
                counter++;
            }
            if (direc == 0 && y == right) {
                direc += 1;
                right += 1;
            } else if (direc == 1 && x == bottom) {
                direc += 1;
                bottom += 1;
            } else if (direc == 2 && y == left) {
                direc += 1;
                left -= 1;
            } else if (direc == 3 && x == top) {
                direc = 0;
                top -= 1;
            }
            x += circle[direc][0];
            y += circle[direc][1];
        }
        return r;
    }
}
