package nowcoder.数组中的最长连续子序列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().MLS(new int[]{4, 4, 6, 5, 5}));
    }

    public int MLS(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        arr = Arrays.stream(arr).distinct().sorted().toArray();
        int len = 1, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1) count++;
            if (arr[i] - arr[i - 1] != 1 || i == arr.length - 1) {
                len = Math.max(len, count);
                count = 1;
            }
        }
        return len;
    }
}
