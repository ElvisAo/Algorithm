package leetcode.数组.在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        int tIndex = -1;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                tIndex = mid;
                break;
            } else if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
        }
        if (tIndex != -1) {
            int i = tIndex, j = tIndex;
            while (i >= 0 && nums[i] == target) i--;
            while (j < nums.length && nums[j] == target) j++;
            return new int[]{i + 1, j - 1};
        } else return new int[]{-1, -1};
    }
}
