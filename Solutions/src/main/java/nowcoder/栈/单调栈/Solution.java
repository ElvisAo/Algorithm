package nowcoder.栈.单调栈;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 注意对比{@link LeetCode热题HOT100.盛最多水的容器.Solution}
 */
public class Solution {
    public static void main(String[] args) {
        int[] t = {3, 4, 1, 5, 6, 2, 7};
        int[][] r = new Solution().solution_1(t);
        for (int[] l : r) System.out.println(Arrays.toString(l));
    }

    public int[][] solution_1(int[] nums) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        int n = nums.length;
        int[][] r = new int[n][2];
        for (int i = 0; i < n; i++) {
            int c = nums[i];
            while (!left.isEmpty() && nums[left.peek()] > c) {
                left.pop();
            }
            r[i][0] = left.isEmpty() ? -1 : left.peek();
            left.push(i);

            int j = n - i - 1;
            c = nums[j];
            while (!right.isEmpty() && nums[right.peek()] > c) {
                right.pop();
            }
            r[j][1] = right.isEmpty() ? -1 : right.peek();
            right.push(j);
        }
        return r;
    }
}
