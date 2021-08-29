package 真题.笔试真题.zoom.滑动窗口;

import java.util.Arrays;
import java.util.LinkedList;


public class Solution {
    class MonoQueue {
        LinkedList<Integer> list = new LinkedList<>();

        public void add(int ele) {
            while (!list.isEmpty() && (ele >= list.peekLast())) list.pollLast();
            list.offerLast(ele);
        }

        public void removeFirst(int ele) {
            if (!list.isEmpty() && list.peekFirst() == ele) list.pollFirst();
        }

        public int peekMax() {
            return list.peekFirst();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int windowSize = 3, step = 2;
        System.out.println(Arrays.toString(new Solution().slideWindow(arr, windowSize, step)));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums       int整型一维数组
     * @param windowSize int整型 滑动窗口大小
     * @param step       int整型 每次移动step个数字
     * @return int整型一维数组
     */
    public int[] slideWindow(int[] nums, int windowSize, int step) {
        if (nums == null || nums.length == 0 || windowSize <= 0 || step <= 0) return new int[]{};
        LinkedList<Integer> list = new LinkedList<>();
        int n = nums.length;
        int left = 0, right = windowSize;
        MonoQueue q = new MonoQueue();
        for (int i = left; i < n && i < right; i++) {
            q.add(nums[i]);
        }
        while (left < n) {
            list.add(q.peekMax());
            for (int i = left; i < n && i < left + step; i++) {
                q.removeFirst(nums[i]);
            }
            for (int i = right; i < n && i < right + step; i++) {
                q.add(nums[i]);
            }
            left += step;
            right += step;
        }
        int[] r = new int[list.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }
}
