package Labuladong及巧妙算法.Binarysearch;

public class LeftBoundary {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 4, 5};
        System.out.println(leftBoundary(nums, 6));
    }

    public static int leftBoundary(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int mid;
        while (lo <= hi) {   // 为什么等于的时候不能取？
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
