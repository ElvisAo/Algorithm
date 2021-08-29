package leetcode.数组.零到N_1中缺失的数字;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(x -> set.add(x));
        int i = 0;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }
}
