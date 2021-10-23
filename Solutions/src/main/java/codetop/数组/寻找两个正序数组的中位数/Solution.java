package codetop.数组.寻找两个正序数组的中位数;

/**
 * leetcode 4
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        /**
         * {@如果是奇数，则left和right是相同的，否则left和right差1，找的是第left和第rihgt个数，而不是索引为left和right的}
         */
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * @param nums1
     * @param i     为nums1的起始位置
     * @param nums2
     * @param j     为nums2的起始位置
     * @param k
     * @return
     */
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
