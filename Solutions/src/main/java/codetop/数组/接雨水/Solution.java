package codetop.数组.接雨水;

/**
 * leetcode 42
 * 左右各扫一遍，记录两遍的最大值
 */
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        int leftMax = height[0], rightMax = height[n - 1];
        for (int i = 0; i < n; i++) {
            left[i] = leftMax;
            if (leftMax < height[i]) leftMax = height[i];
            int j = n - i - 1;
            right[j] = rightMax;
            if (rightMax < height[j]) rightMax = height[j];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            if (minHeight > height[i]) res += minHeight - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}
