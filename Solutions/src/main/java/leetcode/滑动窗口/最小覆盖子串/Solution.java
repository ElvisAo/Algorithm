package leetcode.滑动窗口.最小覆盖子串;

import java.util.HashMap;

/**
 * leetcode 76
 */
public class Solution {
    public String minWindow(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (tlen > slen) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = slen + 1, valid = 0, resLeft = -1, resRight = -1;
        int left = 0, right = 0;
        while (right < slen) {
            char c = s.charAt(right++);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue()) {
                valid++;
            }
            while (valid == map.size()) {
                if (res > right - left) {
                    resLeft = left;
                    resRight = right;
                    res = right - left;
                }
                char d = s.charAt(left++);
                window.put(d, window.get(d) - 1);
                if (map.containsKey(d) && window.get(d).intValue() < map.get(d).intValue()) valid--;
            }
        }
        return res == slen + 1 ? "" : s.substring(resLeft, resRight);
    }
}
