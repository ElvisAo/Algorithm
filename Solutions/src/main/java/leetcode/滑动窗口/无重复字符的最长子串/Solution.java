package leetcode.滑动窗口.无重复字符的最长子串;

import java.util.Arrays;
import java.util.HashSet;

/**
 * leetcode 3
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_1("abcabcbb"));
    }

    public int solution_1(String s) {
        HashSet<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int maxLn = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            while (window.contains(c)) {
                window.remove(s.charAt(left++));
            }
            window.add(c);
            maxLn = Math.max(maxLn, window.size());
        }
        return maxLn;
    }

    public int solution_2(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] arr = new int[256];    // 字符 上次出现的位置
        Arrays.fill(arr, -1);
        int res = -1, last = 0;     // last记录最新重复字符串的位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            last = Math.max(last, arr[index] + 1);
            res = Math.max(res, i - last + 1);
            arr[index] = i;
        }
        return res;
    }
}
