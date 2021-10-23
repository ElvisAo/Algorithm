package codetop.数组.合并区间;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * leetcode 56
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] > y[0] ? 1 : (x[0] < y[0] ? -1 : 0)); // caution：comparator should comply with the reflexivity
        LinkedList<int[]> list = new LinkedList<>();
        list.offerLast(intervals[0]);
        int n = intervals.length;
        int[] last, cur;
        for (int i = 1; i < n; i++) {
            last = list.peekLast();
            cur = intervals[i];
            if (last[1] < cur[0]) list.offerLast(cur);
            else {
                last[1] = Math.max(last[1], cur[1]);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
