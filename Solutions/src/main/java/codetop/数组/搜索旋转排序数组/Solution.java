package codetop.数组.搜索旋转排序数组;

/**
 * leetcode 33
 */
public class Solution {
    /**
     * 1234567 -> 3456712 ->6712345
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length, left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {  // mid小于目标
                if (nums[left] < nums[mid]) {   // 左边有序，则目标在右边
                    left = mid + 1;
                } else {    // 右边有序，则可能在两边，用有序一边的另一边界进行比较
                    if (nums[right] >= target) {   // 在右边
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else if (nums[mid] > target) {
                if (nums[mid] > nums[left]) { // 左边有序
                    if (nums[left] > target) {  // 在右边
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {  //右边有序
                    if (nums[mid] < nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
