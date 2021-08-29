package leetcode.字符串.验证回文字符串Ⅱ;

public class Solution {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new Solution().validPalindrome(s));
    }

    boolean deleteFlag = false;

    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; ) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (deleteFlag) return false;
                else {
                    deleteFlag = true;
                    return validPalindrome(s.substring(i, j)) || validPalindrome(s.substring(i + 1, j + 1));
                }
            }
        }
        return true;
    }
}
