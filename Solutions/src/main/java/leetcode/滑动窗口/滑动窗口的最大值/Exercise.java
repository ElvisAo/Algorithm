package leetcode.滑动窗口.滑动窗口的最大值;

import java.util.Arrays;
import java.util.LinkedList;

public class Exercise {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] r = new Exercise().maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(r));
    }

    class MonoQueue {
        private LinkedList<Integer> q;

        public MonoQueue() {
            q = new LinkedList<>();
        }

        public void offer(int val) {
            while (!q.isEmpty() && q.peekLast() < val) q.removeLast();
            q.offerLast(val);
        }

        public int peekMax() {
            return q.peekFirst();
        }

        public void poll(int ele) {
            if (!q.isEmpty() && q.peekFirst() == ele) q.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoQueue monoQueue = new MonoQueue();
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        for (int i = 0; i < n; i++) {
            monoQueue.offer(nums[i]);
            if (i >= k - 1) {
                r[ri++] = monoQueue.peekMax();
                monoQueue.poll(nums[i - k + 1]);
            }
        }
        return r;
    }
}
