package leetcode.数组.缺失的第一个正数;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution().solution_1(arr));
    }

    public int solution_1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            dfs(nums, nums[i]);
        }
        for (int i = 0; i < n; i++)
            if (i + 1 != nums[i]) return i + 1;
        return n + 1;
    }

    private void dfs(int[] nums, int val) {
        if (val >= 1 && val <= nums.length && val != nums[val - 1]) {
            int nextVal = nums[val - 1];
            nums[val - 1] = val;
            dfs(nums, nextVal);
        }
    }

    public int solution_2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(x -> set.add(x));
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }
}
