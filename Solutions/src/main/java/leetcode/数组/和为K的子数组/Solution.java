package leetcode.数组.和为K的子数组;

import java.util.HashMap;

/**
 * leetcode 560
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(new Solution().subarraySum(nums, k));
    }

    /**
     * preSum + hash
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, res = 0, preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();    // map stored the count of presum
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            int target = preSum - k;
            if (map.containsKey(target)) {
                res += map.get(target);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
