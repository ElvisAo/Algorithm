package Labuladong及巧妙算法.Search.BinarySearch;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 4, 5};
        System.out.println(rightBoundary(nums, 0));
    }

    public static int leftBoundary(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int mid;
        while (lo <= hi) {   // 为什么等于的时候不能取？
            mid = (lo + hi) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return nums[lo] == target ? lo : -1;
    }

    public static int rightBoundary(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] <= target) lo = mid + 1;
            else hi = mid - 1;
        }
        return nums[hi] == target ? hi : -1;
    }
}
