package nowcoder.数学.牛牛算数;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] a = {3,2};
        System.out.println(new Solution().solve(a.length, 2, a));
    }

    public long solve(int n, int c, int[] a) {
        if (a == null || a.length == 0) return 0;
        if (a.length == 1) return c * a[0];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.stream(a).forEach(x -> q.add(x));
        long r = 0;
        while (q.size() > 1) {
            int f = q.poll();
            int s = q.poll();
            r += c * (s + f);
            q.offer(s + f);
        }
        return r;
    }
}
