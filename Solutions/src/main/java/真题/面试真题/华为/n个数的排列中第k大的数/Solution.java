package 真题.面试真题.华为.n个数的排列中第k大的数;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4};
        int k = 2;
        System.out.println(new Solution().solution(t, k));
    }

    public long solution(int[] nums, int k) {
        PriorityQueue<Long> r = new PriorityQueue<>((x, y) -> x > y ? -1 : 1);
        long path = 0;
        HashSet<Integer> visited = new HashSet<>();
        backtrack(nums, path, r, visited);
        while (k > 0 && !r.isEmpty()) {
            r.poll();
            k--;
        }
        if (r.isEmpty()) return -1;
        return r.poll();
    }

    private void backtrack(int[] nums, long path, PriorityQueue<Long> r, HashSet<Integer> visited) {
        int n = nums.length;
        if (("" + path).length() == n) {
            r.add(path);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            path = path * 10 + nums[i];
            visited.add(i);
            backtrack(nums, path, r, visited);
            visited.remove(i);
            path = path / 10;
        }
    }
}
