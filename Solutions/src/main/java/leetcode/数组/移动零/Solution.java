package leetcode.数组.移动零;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 2, 3, 4, 0, -1};
        new Solution().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        int n = nums.length, slow = 0, fast;
        while (slow < n && nums[slow] != 0) slow++;
        fast = slow + 1;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
                nums[fast++] = 0;
            } else {
                fast++;
            }
        }
    }
}
