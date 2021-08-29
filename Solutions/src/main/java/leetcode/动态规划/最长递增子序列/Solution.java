package leetcode.动态规划.最长递增子序列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution_1(int[] nums) {
        int ln = nums.length;
        int[] dp = new int[ln];     // dp[i]：以索引i的元素结尾的递增子序列的长度
        Arrays.fill(dp, 1);
        int r = 1;
        for (int i = 0; i < ln; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    r = Math.max(r, dp[i]);
                }
            }
        }
        return r;
    }

    /**
     * {@动态规划：patience-sort}
     *
     * @param nums
     * @return
     */
    public int solution_2(int[] nums) {
        int ln = nums.length;
        int index = 0;      // 牌的堆数，即最后的最长递增子序列的长度
        int[] top = new int[ln];    // 牌堆顶的元素是left-->right有序的
        for (int i = 0; i < ln; i++) {
            int p = nums[i];
            int left = 0, right = index;    // 左闭右开，找左边界
            while (left < right) {  // 找到比它小的，最大的数
                int mid = left + ((right - left) >> 1);
                if (top[mid] >= p) right = mid;
                else left = mid + 1;
            }
            if (left == index) index++;
            top[left] = p;
        }
        return index;
    }
}
