package 合并区间;

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int left = intervals[0][0], right = intervals[0][1];
        int lastIdx = 0;
        int[][] res = new int[intervals.length][2];
        res[0][0] = left;
        res[0][1] = right;
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res[lastIdx];
            if (last[1] >= intervals[i][0]) {// 有重叠
                last[1] = Math.max(intervals[i][1], last[1]);
            } else {    // 无重叠
                lastIdx++;
                res[lastIdx][0] = intervals[i][0];
                res[lastIdx][1] = intervals[i][1];
            }
        }
        int[][] r = Arrays.copyOf(res, lastIdx+1);
        return r;
    }
}