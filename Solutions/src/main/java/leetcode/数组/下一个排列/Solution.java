package leetcode.数组.下一个排列;

/**
 * 思路及解法
 * <p>
 * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。我们希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。具体地：
 * <p>
 * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
 * <p>
 * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
 * <p>
 * 以排列 [4,5,2,6,3,1][4,5,2,6,3,1][4,5,2,6,3,1] 为例：
 * <p>
 * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 222 与 333，满足「较小数」尽量靠右，而「较大数」尽可能小。
 * <p>
 * 当我们完成交换后排列变为 [4,5,3,6,2,1][4,5,3,6,2,1][4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6][4,5,3,1,2,6][4,5,3,1,2,6]。
 * <p>
 * 具体地，我们这样描述该算法，对于长度为 nnn 的排列 aaa：
 * <p>
 * 首先从后向前查找第一个顺序对 (i,i+1)(i,i+1)(i,i+1)，满足 a[i]<a[i+1]a[i] < a[i+1]a[i]<a[i+1]。这样「较小数」即为 a[i]a[i]a[i]。此时 [i+1,n)[i+1,n)[i+1,n) 必然是下降序列。
 * <p>
 * 如果找到了顺序对，那么在区间 [i+1,n)[i+1,n)[i+1,n) 中从后向前查找第一个元素 jjj 满足 a[i]<a[j]a[i] < a[j]a[i]<a[j]。这样「较大数」即为 a[j]a[j]a[j]。
 * <p>
 * 交换 a[i]a[i]a[i] 与 a[j]a[j]a[j]，此时可以证明区间 [i+1,n)[i+1,n)[i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n)[i+1,n)[i+1,n) 使其变为升序，而无需对该区间进行排序。
 * <p>
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前找尽可能靠右的较小数字a
        while (i >= 0 && nums[i] >= nums[i + 1]) {  // 从后面的数字开始往前找，如果当前数字比后面的，大，继续往前，即略过从后往前的连续升序数组
            i--;    // 注意：i=0还能减，则减为了-1
        }
        if (i >= 0) {   // 找到了尽可能靠右的较小的数字a。注意：i>=0才走这一步，如果i被减为了-1，则说明正个数组的排列已经是最大的，直接走下面的reverse，反转整个数组
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {  // 再从后往前扫描，找到比a大的最小的数字b
                j--;
            }
            swap(nums, i, j);   // 交换这两个数字b
        }
        reverse(nums, i + 1);   // 然后反转后面的b后面的数字
        // 因为把较大的数b换到前面a的位置了，而后面又是降序，所以要反转后面的降序序列，将其转为升序，从而保证其最小
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
