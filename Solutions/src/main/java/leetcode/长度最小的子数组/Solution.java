package leetcode.长度最小的子数组;

public class Solution {
    public static void main(String[] args) {
        int target = 8, nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = -1, right = 0, sum = 0, ln = n + 1;
        while (right < n) {
            int c = nums[right++];
            sum += c;
            while (sum >= target) {
                ln = Math.min(ln, right - left - 1);
                int t = nums[++left];
                sum -= t;
            }
        }
        return ln == n + 1 ? 0 : ln;
    }
}
