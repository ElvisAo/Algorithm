package leetcode.滑动窗口.无重复字符的最长子串;

import java.util.HashSet;

public class Exercise {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int r = 1;
        while (right < n) {
            char c = s.charAt(right++);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            r = Math.max(r, set.size());
        }
        return r;
    }
}
