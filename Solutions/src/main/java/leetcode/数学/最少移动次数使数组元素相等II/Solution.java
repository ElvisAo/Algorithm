package leetcode.数学.最少移动次数使数组元素相等II;

import java.util.Arrays;

/**
 * leetcode 462
 */
public class Solution {
    /**
     * 中位数是最优解
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = n / 2, r = 0;
        for (int i = 0; i < n; i++) {
            if (i == mid) continue;
            r += Math.abs(nums[i] - nums[mid]);
        }
        return r;
    }
}
