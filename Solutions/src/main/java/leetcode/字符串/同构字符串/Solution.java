package leetcode.字符串.同构字符串;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        int n = s.length();
        char c1, c2;
        for (int i = 0; i < n; i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            // integer的比较用equals
            if (smap.getOrDefault(c1, -1).equals(tmap.getOrDefault(c2, -1))) {
                smap.put(c1, i);
                tmap.put(c2, i);
            } else return false;
        }
        return true;
    }
}
