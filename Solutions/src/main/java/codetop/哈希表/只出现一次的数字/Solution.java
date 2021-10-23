package codetop.哈希表.只出现一次的数字;

/**
 * leetcode 136
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) r ^= n;
        return r;
    }
}
