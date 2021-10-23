package codetop.数组.缺失的第一个正数;

/**
 * leetcode 41
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length, next;
        for (int i = 0; i < n; i++) {
            next = nums[i] - 1;
            while (next >= 0 && next < n) {
                swap(nums, i, next);
                next = nums[i] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
