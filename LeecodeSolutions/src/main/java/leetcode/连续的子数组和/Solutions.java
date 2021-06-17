package leetcode.连续的子数组和;

import java.util.HashMap;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(new Solutions().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sum_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_i += nums[i];
            if (preSum.containsKey(sum_i % k)) {
                return true;
            }
            preSum.put((sum_i - nums[i]) % k, i);   // 前缀和模ｋ同余时，则他们的差值就是满足条件的子数组和
        }
        return false;
    }
}
