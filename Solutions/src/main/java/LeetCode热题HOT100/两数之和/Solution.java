package LeetCode热题HOT100.两数之和;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rema = target - nums[i];
            if (map.containsKey(rema)) return new int[]{i, map.get(rema)};
            else map.put(nums[i], i);
        }
        return null;
    }
}
