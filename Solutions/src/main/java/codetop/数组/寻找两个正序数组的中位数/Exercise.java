package codetop.数组.寻找两个正序数组的中位数;

public class Exercise {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i = (n + m + 1) / 2, j = (n + m + 2) / 2;   // 找第i个和第j个
        return (findKth(nums1, 0, nums2, 0, i) + findKth(nums1, 0, nums2, 0, j)) / 2.0;
    }

    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        // 到了这里，k>1，val1, val2是每组中间那个数前面的一个
        int val1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int val2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (val1 < val2) return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        else return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
}
