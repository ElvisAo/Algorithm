package leetcode.双指针.回文子串;

public class Solution {
    public static void main(String[] args) {
        String s = "aca";
        System.out.println(new Solution().countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int r = 1;
        for (int i = 0; i < n - 1; i++) {
            r += countPalindrome(i, i + 1, s);
            r += countPalindrome(i, i, s);
        }
        return r;
    }

    private int countPalindrome(int i, int j, String s) {
        int r = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            r++;
            j++;
            i--;
        }
        return r;
    }
}
