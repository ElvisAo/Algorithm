package LeetCode热题HOT100.最长回文子串;

public class Solution {
    public static void main(String[] args) {
    }

    public String longestPalindrome(String s) {
        int r = 0, n = s.length(), rl = 0, rr = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int t = helper(s, i, i + 1);
                if (r < t) {
                    r = t;
                    rl = i - t / 2 + 1;
                    rr = i + t / 2;
                }
            }
            int t = helper(s, i, i);
            if (r < t) {
                r = t;
                rl = i - t / 2;
                rr = i + t / 2;
            }
        }
        return s.substring(rl, rr + 1);
    }

    /**
     * 或者在这里直接返回结果串，后面就不用计算rl,rr了
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    private int helper(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }
}
