package codetop.数组.在排序数组中查找元素的第一个和最后一个位置;

/**
 * leetcode 34
 *
 * @see Labuladong及巧妙算法.Search.BinarySearch.Solution
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) { // 因为==的时候while会继续，所以在循环里面当==时一定要移动
            mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;     // 因为是找左边界，所以当相等的时候应该是right=mid-1
        }
        if (left == nums.length || nums[left] != target) return res;
        res[0] = left;
        right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        res[1] = right;
        return res;
    }
}
