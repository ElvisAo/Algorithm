package leetcode.模拟.前K个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    class Pair {
        int val, freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) map.put(ele, map.getOrDefault(ele, 0) + 1);
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int[] r = new int[k];
        for (int i = 0; i < k; i++) {
            r[i] = q.poll().val;
        }
        return r;
    }
}
