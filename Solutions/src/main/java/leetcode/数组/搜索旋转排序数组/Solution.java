package leetcode.数组.搜索旋转排序数组;

/**
 * 对于旋转数组，先判断是否找到目标，如果没有，再判断哪边是有序的，从而确定下一个搜索区间
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        return searchHelper(nums, target, lo, hi);
    }

    public int searchHelper(int[] nums, int target, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + ((hi - lo) >> 1);
        if (nums[mid] == target) return mid;
        else if (nums[lo] <= nums[mid]) {    // 左边有序
            if (nums[lo] <= target && nums[mid] > target)
                return searchHelper(nums, target, lo, mid - 1);
            else return searchHelper(nums, target, mid + 1, hi);
        } else if (nums[mid] <= nums[hi]) {
            if (nums[mid + 1] <= target && target <= nums[hi])
                return searchHelper(nums, target, mid + 1, hi);
            else return searchHelper(nums, target, lo, mid - 1);
        }
        return -1;
    }
}
