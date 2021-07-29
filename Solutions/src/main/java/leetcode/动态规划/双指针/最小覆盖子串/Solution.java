package leetcode.动态规划.双指针.最小覆盖子串;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String s = "aa", t = "aa";
        System.out.println(new Solution().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int valide = 0;
        int left = 0, right = 0;
        int start = 0, ln = s.length() + 1;
        HashMap<Character, Integer> window = new HashMap<>();
        int n = s.length();
        while (right < n) {
            char c = s.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (map.containsKey(c)) {
                if (window.get(c).intValue() == map.get(c).intValue()) valide++;
            }

            while (valide == map.size()) {
                int windowSize = right - left;
                if (ln > windowSize) {
                    start = left;
                    ln = windowSize;
                }
                char d = s.charAt(left++);
                int cnt = window.get(d);
                if (cnt == 1) {
                    window.remove(d);
                } else window.put(d, cnt - 1);
                if (map.containsKey(d) && map.get(d).intValue() > window.getOrDefault(d, 0)) valide--;
            }
        }
        return ln == s.length() + 1 ? "" : s.substring(start, start + ln);
    }
}
