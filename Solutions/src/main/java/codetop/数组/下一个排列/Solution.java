package codetop.数组.下一个排列;

/**
 * leetcode 31
 * 跑两个用例模拟一遍很多思路就清楚了。
 * 1. 找靠右的较小值；2. 找这个较小值右边的恰好比他大的值；3. 交换这两个值；4. 反转从较小值的原始位置到最后的数组
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }   // 找到第一个比较小的，可能减到-1
        if (i == -1) {
            reverse(nums, 0);
            return;
        }
        int j = n - 1;
        while (nums[j] <= nums[i]) j--;  // 找到右边第一个比他大的
        swap(nums, i, j);
        reverse(nums, i + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
