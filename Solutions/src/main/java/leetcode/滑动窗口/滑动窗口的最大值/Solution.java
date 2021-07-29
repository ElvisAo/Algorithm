package leetcode.滑动窗口.滑动窗口的最大值;

import java.util.LinkedList;

public class Solution {
    class MonoQueue<T extends Comparable<T>> {
        private LinkedList<T> q = new LinkedList<>();

        public void push(T ele) {
            while ((!q.isEmpty()) && q.getLast().compareTo(ele) < 0) q.removeLast();
            q.addLast(ele);
        }

        public T max() {
            return q.getFirst();
        }

        public void pop(T ele) {
            if (!q.isEmpty() && q.getFirst().equals(ele)) q.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int[] r = new int[nums.length - k + 1];
        int ri = 0;
        MonoQueue<Integer> q = new MonoQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.push(nums[i]);
            if (i >= k - 1) {
                r[ri++] = q.max();
                q.pop(nums[i - k + 1]);
            }
        }
        return r;
    }
}
