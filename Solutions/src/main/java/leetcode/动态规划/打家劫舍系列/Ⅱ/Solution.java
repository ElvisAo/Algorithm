package leetcode.动态规划.打家劫舍系列.Ⅱ;

public class Solution {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int start, int end) {
        int pre_0 = 0, pre_1 = nums[start], t;
        for (int i = start + 1; i <= end; i++) {
            t = pre_0;
            pre_0 = Math.max(pre_1, pre_0);
            pre_1 = t + nums[i];
        }
        return Math.max(pre_0, pre_1);
    }
}
