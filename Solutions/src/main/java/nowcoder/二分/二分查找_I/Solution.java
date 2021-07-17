package nowcoder.二分.二分查找_I;

public class Solution {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
        }
        return -1;
    }
}
