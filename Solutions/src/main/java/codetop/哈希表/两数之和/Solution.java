package codetop.哈希表.两数之和;

import java.util.HashMap;

/**
 * leetcode 1
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) return res;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (map.containsKey(target - v)) {
                res[0] = map.get(target - v);
                res[1] = i;
                break;
            }
            map.put(v, i);
        }
        return res;
    }
}
