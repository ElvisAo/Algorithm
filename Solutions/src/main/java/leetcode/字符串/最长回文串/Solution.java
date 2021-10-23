package leetcode.字符串.最长回文串;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 409
 */
public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int r = 0, n = s.length();
        boolean flag = false;
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++) {
            charMap.put(array[i], charMap.getOrDefault(array[i], 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            r += entry.getValue() % 2 == 0 ? entry.getValue() : entry.getValue() - 1;
            if (!flag && entry.getValue() % 2 == 1) {
                r += 1;
                flag = true;
            }
        }
        return r;
    }
}
