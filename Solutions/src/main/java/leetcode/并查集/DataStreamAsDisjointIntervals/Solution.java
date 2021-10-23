package leetcode.并查集.DataStreamAsDisjointIntervals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * leetcode 352
 */
public class Solution {
    public static void main(String[] args) {
        int[] vals = {6, 6, 0, 4, 8, 7, 6, 4, 7, 5};
        SummaryRanges sr = new SummaryRanges();
        for (int i = 0; i < vals.length; i++) {
            sr.addNum(vals[i]);
            int[][] intervals = sr.getIntervals();
            for (int[] itv : intervals) {
                System.out.print(Arrays.toString(itv) + "\t");
            }
            System.out.println();
        }
    }
}

class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;
    private HashSet<Integer> visited;

    public SummaryRanges() {
        intervals = new TreeMap<Integer, Integer>((x, y) -> x.compareTo(y));
        visited = new HashSet<>();
    }

    public void addNum(int val) {
        if (visited.contains(val)) return;
        visited.add(val);
        int oldVal = val;
        int start = val, end = val;
        while (visited.contains(val - 1)) {
            val--;
        }
        start = val;
        intervals.remove(val);
        val = oldVal;
        if (intervals.containsKey(val + 1)) {
            end = intervals.get(val + 1);
            intervals.remove(val + 1);
        }
        intervals.put(start, end);
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            res[i++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return res;
    }
}
