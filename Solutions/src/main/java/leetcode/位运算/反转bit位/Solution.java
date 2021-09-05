package leetcode.位运算.反转bit位;

/**
 * leetcode 190
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0, mask = 1;
        for (int i = 0; i < 32; i++) {  // 注意：这里不能用while(n>0)
            r <<= 1;
            r += n & mask;
            n >>= 1;
        }
        return r;
    }
}
