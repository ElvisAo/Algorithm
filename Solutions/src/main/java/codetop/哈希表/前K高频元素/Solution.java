package codetop.哈希表.前K高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    class Pair {
        int v;
        int freq;

        public Pair(int v, int freq) {
            this.v = v;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.freq > y.freq ? -1 : 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k && !q.isEmpty()) {
            res[i++] = q.poll().v;
        }
        return res;
    }
}
