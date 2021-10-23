package codetop.数组.寻找旋转排序数组中的最小值;

/**
 * leetcode 153
 */
public class Solution {
    // 二分查找，只与右边比较，两种case
    public int findMin(int[] nums) {
        if (nums.length == 1 || (nums[0] < nums[1] && nums[0] < nums[nums.length - 1])) return nums[0];
        int n = nums.length, left = 0, right = n - 1, mid = -1;
        while (left < right) {  // 注意：right的初值为n-1，但是这里却是left<right，所以当left==right，即区间内只有一个元素时，会跳出循环
            mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {   // 右边升序
                right = mid;    // 为什么不是mid-1？因为mid可能是答案。而while是当区间内只剩一个元素时，选择这个剩余的元素当答案的
            } else {    // 左边升序
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
