package codetop.数组.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;

/**
 * leetcode 128
 */
public class Solution {

    public int solution_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, res = -1;
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(x -> set.add(x));
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (set.contains(v + 1)) continue;
            while (set.contains(v - 1)) v--;
            // 虽然有while，但是本质上时间复杂度只有n，因为当有n+1时，continue了，所以对于连续的数，只会从最大的数开始往小的找长度
            res = Math.max(res, nums[i] - v + 1);
        }
        return res;
    }
}
