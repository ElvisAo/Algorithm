package nowcoder.滑动窗口.最长无重复子数组;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxLength(int[] arr) {
        int n = arr.length, maxLength = 0;
        if (arr == null || arr.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < n) {
            int c = arr[right++];

            while (set.contains(c)) {
                int d = arr[left++];
                set.remove(d);
            }
            set.add(c);
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
