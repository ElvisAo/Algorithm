package leetcode.位运算.只出现一次的数字III;

/**
 * leetcode 260
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int t = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            t ^= nums[i];
        }
        int mask = 1;
        while ((t & mask) == 0) mask <<= 1;
        int r0 = 0, r1 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & mask) == 0) {
                r0 ^= nums[i];
            } else {
                r1 ^= nums[i];
            }
        }
        return new int[]{r0, r1};
    }
}
