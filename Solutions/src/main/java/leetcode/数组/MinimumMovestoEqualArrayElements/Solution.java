package leetcode.数组.MinimumMovestoEqualArrayElements;

/**
 * leetcode 453
 */
public class Solution {
    /**
     * n-1个数之后使得n个数相等，等价于每次让一个数-1，最后所有的数相等
     */
    public int minMoves(int[] nums) {
        int n = nums.length, res = 0;
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            if (min > nums[i]) min = nums[i];
        }
        for (int i = 0; i < n; i++) {
            res += nums[i] - min;
        }
        return res;
    }
}
