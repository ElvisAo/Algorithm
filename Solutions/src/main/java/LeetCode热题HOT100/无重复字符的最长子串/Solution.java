package LeetCode热题HOT100.无重复字符的最长子串;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int maxLn = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            while (window.contains(c)) {
                char d = s.charAt(left++);
                window.remove(d);
            }
            window.add(c);
            maxLn = Math.max(maxLn, window.size());
        }
        return maxLn;
    }
}
