package leetcode.字符串.最长回文子串;

public class Exercise {
    public static void main(String[] args) {
        String s = "babad";

        System.out.println(new Exercise().solution_1(s));
    }

    public String solution_1(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length(), resLen = 0, resL = -1, resR = -1, t;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t = helper(s, i, i + 1);
                if (t > resLen) {
                    resLen = t;
                    resL = i - t / 2 + 1;
                    resR = i + t / 2 + 1;
                }
            }
            t = helper(s, i, i);
            if (t > resLen) {
                resLen = t;
                resL = i - t / 2;
                resR = i + t / 2 + 1;
            }
        }
        return s.substring(resL, resR);
    }

    private int helper(String s, int i, int j) {
        while (i >= 0 && i < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
