package nowcoder.合并区间;

import common.Interval;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (x, y) -> x.start - y.start);
        ArrayList<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return list;
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval intv = intervals.get(i);
            Interval last = list.get(list.size() - 1);
            if (last.end < intv.start) list.add(intv);
            else {
                Interval v = new Interval(Math.min(intv.start, last.start), Math.max(intv.end, last.end));
                list.remove(last);
                list.add(v);
            }
        }
        return list;
    }
}
