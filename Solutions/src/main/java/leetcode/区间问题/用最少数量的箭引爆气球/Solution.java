package leetcode.区间问题.用最少数量的箭引爆气球;

import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        System.out.println(new Solution().exercise_1(points));
    }

    /**
     * {@区间问题：不重复区间的数量}
     * {@注意点：排序时如果使用-的形式，容易溢出}
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> {
            if (x[1] > y[1]) return 1;  // 这里必须是这种形式，如果使用x[1]-y[1]的形式，容易溢出
            else return -1;
        });
        int counter = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                counter++;
            }
        }
        return counter;
    }

    /****************{@练习}***************/
    public int exercise_1(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (x, y) -> x[1] > y[1] ? 1 : -1);
        if (points.length == 1) return 1;
        int[] pre = points[0], cur;
        int counter = 1;
        for (int i = 1; i < points.length; i++) {
            cur = points[i];
            if (cur[0] > pre[1]) {
                pre = cur;
                counter++;
            }
        }
        return counter;
    }
}
