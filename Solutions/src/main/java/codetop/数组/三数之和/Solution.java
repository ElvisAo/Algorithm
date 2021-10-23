package codetop.数组.三数之和;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 15
 * 先排序，再转换为两个数之和。一个关键点在于如何去重
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> olist = new LinkedList<>();
        if (nums == null || nums.length == 0) return olist;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {   // 第一个数
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1, target = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    olist.add(new LinkedList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right + 1] == nums[right]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return olist;
    }
}
