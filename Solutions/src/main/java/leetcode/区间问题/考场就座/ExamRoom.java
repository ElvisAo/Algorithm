package leetcode.区间问题.考场就座;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ExamRoom {
    private TreeSet<int[]> pq;
    private Map<Integer, int[]> startMap;
    private Map<Integer, int[]> endMap;
    private int N;

    public ExamRoom(int n) {
        this.N = n;
        pq = new TreeSet<>((x, y) -> {
            int xl = distance(x), yl = distance(y);
            if (xl == yl) return -1 * (x[0] - y[0]);    // 起始索引小的放后面
            else return xl - yl;
        });
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        addInterval(new int[]{-1, N});
    }

    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    private int distance(int[] x) {
        int i = x[0], j = x[1];
        if (i == -1) return j;
        if (j == N) return N - 1 - i;
        return (j - i) >> 1;
    }

    public int seat() {
        int[] longest = pq.last();
        int set = -1;
        if (longest[0] == -1) set = 0;
        else if (longest[1] == N) set = N - 1;
        else set = longest[0] + ((longest[1] - longest[0]) >> 1);
        pq.remove(longest);
        int[] left = {longest[0], set}, right = {set, longest[1]};
        addInterval(left);
        addInterval(right);
        return set;
    }

    public void leave(int p) {
        int[] s = endMap.get(p);
        int[] e = startMap.get(p);
        removeInterval(s);
        removeInterval(e);
        addInterval(new int[]{s[0], e[1]});
    }
}
