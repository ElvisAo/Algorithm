package leetcode.模拟.螺旋矩阵系列.螺旋矩阵III;

/**
 * leetcode 885
 * reference from labuladong
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 仅考虑当前这一圈的边界，当到达某个方面的边界后，如果还应该继续循环，就改变方向，并把这个方面的边界+1
     *
     * @param R  总行数
     * @param C  总列数
     * @param r0 起始行数
     * @param c0 起始列数
     * @return
     */
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int[][] around = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};    // 往右、下、左、上的顺序移动
        int x = r0, y = c0, num = 1, dir = 0;  //{x, y}为当前位置，num为当前查找的数字，dir为当前的方向
        int Left = c0 - 1, Right = c0 + 1, Upper = r0 - 1, Bottom = r0 + 1;  //四个方向的边界。仅当前这一圈的
        while (num <= R * C) {
            // 每次只考虑一个节点
            if (x >= 0 && x < R && y >= 0 && y < C) {  //{x， y}位置在矩阵中
                res[num - 1] = new int[]{x, y};
                num++;
            }
            if (dir == 0 && y == Right) {  //向右到右边界
                dir += 1;  //调转方向向下
                Right += 1;  //右边界右移
            } else if (dir == 1 && x == Bottom) {  //向下到底边界
                dir += 1;
                Bottom += 1;  //底边界下移
            } else if (dir == 2 && y == Left) {  //向左到左边界
                dir += 1;
                Left--;  //左边界左移
            } else if (dir == 3 && x == Upper) {  //向上到上边界
                dir = 0;
                Upper--;  //上边界上移
            }
            // 在当前的方向上移动
            x += around[dir][0];   //下一个节点
            y += around[dir][1];
        }
        return res;
    }
}
