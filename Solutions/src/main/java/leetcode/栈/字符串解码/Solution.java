package leetcode.栈.字符串解码;

public class Solution {
    private boolean onlyString(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '[' || c == ']') return false;
        }
        return true;
    }

    public String decodeString(String s) {
        int n = s.length();
        char c;
        StringBuilder r = new StringBuilder(n);
        int counter = 0;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') { // 如果是数字
                counter = counter * 10 + (c - '0');
            } else if (c == '[') {
                int j = n - 1;
                while (s.charAt(j) != ']') j--;
                String subS = decodeString(s.substring(i, j + 1));
                for (int ctr = 0; ctr < counter; ctr++) {
                    r.append(subS);
                }
            }
        }
        return r.toString();
    }
}
