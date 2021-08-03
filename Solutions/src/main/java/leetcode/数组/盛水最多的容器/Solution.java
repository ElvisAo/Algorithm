package leetcode.数组.盛水最多的容器;

/**
 * 主要对比 {@link nowcoder.栈.单调栈.Solution}
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().solution_2(array));
    }

    /**
     * {@暴力：超时}
     * {@关于暴力法的思考： 1. 有哪些情况：左边界可能有很多个，右边界可能有很多个情况 2. 但是无非都在数组中，双层循环遍历即可}
     *
     * @param height
     * @return
     */
    public int solution_1(int[] height) {
        int n = height.length;
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                r = Math.max(r, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return r;
    }

    /**
     * {@动态规划}
     * 每次移动小的一边，因为移动小的一边，才可能在缩小宽的情况下通过找到更大的高来使得面积更大，
     * 如果移动大的一边，不仅宽变小， 高也变小了，显然不合理
     *
     * @param height
     * @return
     */
    public int solution_2(int[] height) {
        int n = height.length;
        int r = 0, left, right;
        for (int i = 0, j = n - 1; i < j; ) {
            left = height[i];
            right = height[j];
            r = Math.max(r, (j - i) * Math.min(left, right));
            if (left < right) i++;
            else j--;
        }
        return r;
    }
}
