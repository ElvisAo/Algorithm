package leetcode.数组.寻找两个正序数组的中位数;

public class Solution {
    public static void main(String[] args) {
        int[] a1 = {1, 2}, a2 = {3, 4};
        System.out.println(new Solution().solution_1(a1, a2));
    }

    /**
     * {@归并排序}
     * {@可以进一步的优化，归并到中位数就停止归并}
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution_1(int[] nums1, int[] nums2) {
        int ln1 = nums1.length, ln2 = nums2.length;
        int ln = ln1 + ln2;
        int[] r = new int[ln];
        int i = 0, j = 0, k = 0;
        while (i < ln1 && j < ln2) {
            if (nums1[i] < nums2[j]) {
                r[k++] = nums1[i++];
            } else {
                r[k++] = nums2[j++];
            }
        }
        while (i < ln1) r[k++] = nums1[i++];
        while (j < ln2) r[k++] = nums2[j++];
        if (ln % 2 == 1) return 1.0 * r[ln / 2];
        else return (r[ln / 2] + r[ln / 2 - 1]) / 2.0;
    }

    /**
     * {@二分查找}
     * TODO 待深化理解
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double solution_2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        /**
         * {@如果是奇数，则left和right是相同的，否则left和right差1}
         */
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * {@对K二分，意思是我们需要分别在nums1和nums2中查找第K/2个元素}
     *
     * @param nums1
     * @param i     为nums1的起始位置
     * @param nums2
     * @param j     为nums2的起始位置
     * @param k
     * @return
     */
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];     //nums1为空数组
        if (j >= nums2.length) return nums1[i + k - 1];     //nums2为空数组
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;    // maxValue是为了在中位数取不到的时候将其完全淘汰
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
