package leetcode.数组.所有奇数长度子数组的和;

public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0, n = arr.length;
        int[] preSum = new int[n + 1];  // preSum[i]:包括索引i的元素在内的前缀和
        preSum[1] = arr[0];
        for (int i = 1; i < n; i++) preSum[i + 1] = preSum[i] + arr[i];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if ((j - i) % 2 == 0) continue;
                sum += preSum[j] - preSum[i];
            }
        }
        return sum;
    }
}
