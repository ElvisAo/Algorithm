package leetcode.位运算.只出现一次的数字;

public class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n : nums) r ^= n;
        return r;
    }
}
