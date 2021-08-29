package leetcode.模拟.数据流的中位数;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }

    class MedianFinder {
        PriorityQueue<Integer> minQueue;    // 存储较大的一半
        PriorityQueue<Integer> maxQueue;    // 存储较小的一半
        int n;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minQueue = new PriorityQueue<>((x, y) -> x > y ? 1 : -1);
            maxQueue = new PriorityQueue<>((x, y) -> x > y ? -1 : 1);
            n = 0;
        }

        public void addNum(int num) {
            n++;
            if (n % 2 == 1) {
                minQueue.offer(num);
                maxQueue.offer(minQueue.poll());
            } else {
                maxQueue.offer(num);
                minQueue.offer(maxQueue.poll());
            }
        }

        public double findMedian() {
            if (n % 2 == 1) {
                return maxQueue.peek();
            } else {
                return (maxQueue.peek() + minQueue.peek()) / 2.0;
            }
        }
    }
}
