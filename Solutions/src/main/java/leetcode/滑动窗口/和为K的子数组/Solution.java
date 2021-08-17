package leetcode.滑动窗口.和为K的子数组;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println(new Solution().solution_2(arr, k));
    }

    public int solution_1(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            preSum[i] = preSum[i - 1] + nums[i - 1];
        int r = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    r++;
                }
            }
        }
        return r;
    }

    /**
     * {@前缀和+hashMap优化}
     *
     * @param nums
     * @param k
     * @return
     */
    public int solution_2(int[] nums, int k) {
        int n = nums.length;
        int preSum = 0, t, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {   // preSum记录的是到目前为止的全部和，所以map的value应该是出现次数
            preSum += nums[i];
            t = preSum - k;
            if (map.containsKey(t)) r += map.get(t);    // 这里计算个数的时候就需要r+=map.get(t)
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return r;
    }
}
