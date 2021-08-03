package leetcode.双指针.合并两个有序数组;

public class Solution {
    public static void main(String[] args) {

    }

    public void solution_1(int[] nums1, int m, int[] nums2, int n) {
        int[] r = new int[m + n];
        int i = 0, j = 0, k = 0;
        for (; i < m && j < n; ) {
            if (nums1[i] < nums2[j]) {
                r[k++] = nums1[i++];
            } else r[k++] = nums2[j++];
        }
        while (i < m) r[k++] = nums1[i++];
        while (j < n) r[k++] = nums2[j++];
        for (int idx = 0; idx < nums1.length; idx++) {
            nums1[idx] = r[idx];
        }
    }

    public void solution_2(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) nums1[k--] = nums1[m--];
            else nums1[k--] = nums2[n--];
        }
        while (n >= 0) nums1[k--] = nums2[n--];
    }
}
