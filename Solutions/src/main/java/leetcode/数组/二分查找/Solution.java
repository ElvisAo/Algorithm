package leetcode.数组.二分查找;

/**
 * leetcode 704
 */
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
