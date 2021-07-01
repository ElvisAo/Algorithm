package leetcode.删除被覆盖区间;

import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) return y[1] - x[1];
            return x[0] - y[0];
        });
        int res = 0;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (left < intervals[i][0] && right > intervals[i][1]) {    // 覆盖
                res++;
            } else if (right >= intervals[i][0] && right <= intervals[i][1]) {
                right = intervals[i][1];
            } else if (right < intervals[i][0]) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}