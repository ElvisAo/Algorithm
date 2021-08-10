package 真题.面试真题.字节.最长回文子串的长度;

public class Main {
    public static void main(String[] args) {
        String s = "aca";
        System.out.println(helper(s));
    }

    public static int helper(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length(), r = 1, t = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                t = max(s, i, i + 1);
            } else {
                t = max(s, i, i);
            }
            r = r > t ? r : t;
        }
        return r;
    }

    private static int max(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}