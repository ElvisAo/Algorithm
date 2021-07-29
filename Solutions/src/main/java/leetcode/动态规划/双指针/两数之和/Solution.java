package leetcode.动态规划.双指针.两数之和;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15}, target = 9;
        System.out.println(new Solution().twoSum(nums, 9));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] r = new int[2];
        int n = numbers.length;
        for (int i = 0, j = n - 1; i < j; ) {
            int pre = numbers[i], pos = numbers[j];
            if (pre + pos == target) {
                r[0] = i;
                r[1] = j;
                return r;
            } else if (pre + pos > target) j--;
            else if (pre + pos < target) i++;
        }
        return r;
    }

    public int[] solution_2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int t = target - numbers[i];
            if (map.containsKey(t)) {
                return new int[]{map.get(t) + 1, i + 1};
            } else map.put(numbers[i], i);
        }
        return null;
    }
}
