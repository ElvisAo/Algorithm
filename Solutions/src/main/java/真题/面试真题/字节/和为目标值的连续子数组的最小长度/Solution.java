package 真题.面试真题.字节.和为目标值的连续子数组的最小长度;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int s = 13;
        System.out.println(helper(nums, s));
    }

    private static int helper(int[] nums, int s) {
        int left = 0, right = 0, sum = 0, c;
        int n = nums.length, r = n + 1;
        while (right < n) {
            c = nums[right++];
            sum += c;
            while (sum >= s) {
                r = Math.min(r, right - left);
                sum -= nums[left++];
            }
        }
        return r;
    }
}
