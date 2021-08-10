package leetcode.模拟.柱状图中的最大矩形;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new Solution().solution_2(heights));
    }

    /**
     * {@暴力：枚举所有的柱子，从该柱子往两遍扩散，遇到比该柱子矮的柱子就停下}
     *
     * @param heights
     * @return
     */
    public int solution_1(int[] heights) {
        int n = heights.length, r = 0, j, k, area;
        for (int i = 0; i < n; i++) {
            j = k = i;
            while (j >= 0 && heights[j] >= heights[i]) j--;
            while (k < n && heights[k] >= heights[i]) k++;
            area = heights[i] * (k - j - 1);
            r = r > area ? r : area;
        }
        return r;
    }

    /**
     * {@单调栈：对每个位置i，记录左右比他矮的位置}
     *
     * @param heights
     * @return
     */
    public int solution_2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int n = heights.length, j, r = 0, area;
        int[] llower = new int[n];
        int[] rlower = new int[n];
        for (int i = 0; i < n; i++) {
            while (!left.isEmpty() && heights[left.peek()] >= heights[i]) {
                left.pop();
            }
            llower[i] = left.isEmpty() ? -1 : left.peek();
            left.push(i);

            j = n - i - 1;
            while (!right.isEmpty() && heights[right.peek()] >= heights[j]) {
                right.pop();
            }
            rlower[j] = right.isEmpty() ? n : right.peek();
            right.push(j);
        }
        for (int i = 0; i < n; i++) {
            area = (rlower[i] - llower[i] - 1) * heights[i];
            r = r > area ? r : area;
        }
        return r;
    }
}
