package leetcode.数组.寻找重复数;

public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, val;
        for (int i = 0; i < n; i++) {
            val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) return val;
            else nums[val - 1] *= -1;
        }
        return -1;
    }
}
