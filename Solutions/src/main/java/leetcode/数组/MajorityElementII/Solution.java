package leetcode.数组.MajorityElementII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * leetcode 229
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) res.add(entry.getKey());
        }
        return res;
    }
}
