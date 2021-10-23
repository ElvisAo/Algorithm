package codetop.数组.寻找峰值;

/**
 * TODO 未完成
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == nums[right]) right--;
            else if (nums[mid] < nums[right]) left = mid;
            else right = mid;
        }
        return nums[right];
    }
}
