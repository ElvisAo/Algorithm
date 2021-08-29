package 真题.面试真题.腾讯.最长回文子串;

public class Solution {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(solution(s));
    }

    static String r = "";

    public static String solution(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            helper(s, i, i + 1);
            helper(s, i, i);
        }
        return r;
    }

    public static void helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > r.length()) r = s.substring(i + 1, j);
    }
}
