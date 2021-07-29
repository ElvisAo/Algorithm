package leetcode.区间问题.划分字母区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * {@本质：合并重叠区间}
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[][] interval = new int[26][2];
        int n = s.length();
        for (int[] part : interval) {
            Arrays.fill(part, -1);
        }
        for (int i = 0; i < n; i++) {   // 处理为区间
            int cIndex = s.charAt(i) - 'a';
            if (interval[cIndex][0] == -1) interval[cIndex][0] = i;
            interval[cIndex][1] = Math.max(interval[cIndex][1], i);
        }
        Arrays.sort(interval, (x, y) -> x[0] > y[0] ? 1 : -1);
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < interval.length; i++) {
            int[] cur = interval[i];
            if (cur[0] == -1) continue;
            if (list.isEmpty()) list.offer(cur);
            else {
                int[] last = list.getLast();
                if (last[1] < cur[0]) {
                    list.offer(cur);
                } else {
                    last[1] = Math.max(last[1], cur[1]);
                }
            }
        }
        ArrayList<Integer> r = new ArrayList<>(list.size());
        for (int[] itv : list) {
            r.add(itv[1] - itv[0] + 1);
        }
        return r;
    }
}
