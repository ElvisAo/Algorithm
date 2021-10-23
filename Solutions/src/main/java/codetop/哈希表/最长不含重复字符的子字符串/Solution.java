package codetop.哈希表.最长不含重复字符的子字符串;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 剑指 Offer 48
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 1, left = 0, right = 0, n = s.length();
        HashSet<Character> set = new HashSet<>();
        while (right < n) {
            char c = s.charAt(right++);
            if (!set.contains(c)) {
                res = Math.max(res, right - left);
            }
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
        }
        return res;
    }

    public int solution_2(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), res = 0, last = 0;
        int[] counter = new int[256];
        Arrays.fill(counter, -1);   // why need this operation and the below need to add 1?
        // because the variable last is the real position of the character appeared, so it is
        // inappropriate to make them -1
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            last = Math.max(last, counter[index] + 1);
            res = Math.max(res, i - last + 1);
            counter[index] = i;
        }
        return res;
    }
}
